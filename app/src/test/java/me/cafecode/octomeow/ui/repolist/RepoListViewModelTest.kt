package me.cafecode.octomeow.ui.repolist

import android.arch.lifecycle.Observer
import io.reactivex.Flowable
import me.cafecode.octomeow.model.ObservingResult
import me.cafecode.octomeow.scheduler.ImmediateScheduler
import me.cafecode.repository.RepoRepository
import me.cafecode.repository.model.Repo
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class RepoListViewModelTest {

    lateinit var viewModel: RepoListViewModel
    val scheduler = ImmediateScheduler()
    val repoRepository = mock(RepoRepository::class.java)

    @Before
    fun setUp() {
        viewModel = RepoListViewModel(scheduler, repoRepository)
        val observer = mock(Observer::class.java) as Observer<ObservingResult<List<Repo>>>
        viewModel.reposData.observeForever(observer)
    }

    @Test
    fun refreshRepos() {
        `when`(repoRepository.getRepositories()).thenReturn(Flowable.just(listOf(Repo())))
        viewModel.refreshRepos()
        verify(repoRepository).getRepositories()
        assert(viewModel.reposData.value is ObservingResult.Success)
    }

    @Test
    fun loadNextPage() {
        val repos = (1..20).map { Repo(id = it) }
        `when`(repoRepository.getRepositories())
                .thenReturn(Flowable.just(repos.filter { it.id in 1..5 }))
        `when`(repoRepository.getNextReppositories("5"))
                .thenReturn(Flowable.just(repos.filter { it.id in 6..10 }))

        viewModel.refreshRepos()
        viewModel.loadNextPage()

        val actualRepos = (viewModel.reposData.value as ObservingResult.Success<List<Repo>>).data
        assertEquals(repos.filter { it.id in 1..10 }, actualRepos)
    }
}
