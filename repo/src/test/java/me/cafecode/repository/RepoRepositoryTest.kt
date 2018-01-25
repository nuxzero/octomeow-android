package me.cafecode.repository

import io.reactivex.Flowable
import me.cafecode.repository.api.GithubApi
import me.cafecode.repository.model.Repo
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class RepoRepositoryTest {

    val api = mock(GithubApi::class.java)
    lateinit var repository: RepoRepository

    @Before
    fun setUp() {
        repository = RepoRepository(api)
    }

    @Test
    fun getRepositories() {
        `when`(api.getRepositories()).thenReturn(Flowable.just(listOf(Repo())))

        val testSubscriber = repository.getRepositories().test()

        testSubscriber.assertComplete()
        verify(api).getRepositories()
    }

    @Test
    fun getNextPageRepositories() {
//       `when`(api.getNextPageRepositories("368")).
    }

}
