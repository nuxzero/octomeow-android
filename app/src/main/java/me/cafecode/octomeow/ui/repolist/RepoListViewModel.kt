package me.cafecode.octomeow.ui.repolist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import me.cafecode.octomeow.extension.addTo
import me.cafecode.octomeow.model.ObservingResult
import me.cafecode.octomeow.scheduler.BaseScheduler
import me.cafecode.octomeow.ui.base.BaseViewModel
import me.cafecode.repository.RepoRepository
import me.cafecode.repository.model.Repo
import javax.inject.Inject


open class RepoListViewModel @Inject constructor(
        private val scheduler: BaseScheduler,
        private val repoRepository: RepoRepository)
    : BaseViewModel() {

    private val reposObserveData = MutableLiveData<ObservingResult<List<Repo>>>()

    open var reposData: LiveData<ObservingResult<List<Repo>>> =
            Transformations.map(reposObserveData, { it })

    fun refreshRepos() {
//        Completable.create { reposObserveData.postValue(ObservingResult.Loading(null)) }

//        reposObserveData.value = ObservingResult.Loading(null)
        repoRepository.getRepositories()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(
                        { reposObserveData.postValue(ObservingResult.Success(it)) },
                        { reposObserveData.postValue(ObservingResult.Failure(it)) }
                )
                .addTo(disposable)
    }

    fun loadNextPage() {

    }
}
