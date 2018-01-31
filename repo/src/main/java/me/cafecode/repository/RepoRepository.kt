package me.cafecode.repository

import io.reactivex.Flowable
import me.cafecode.repository.api.GithubApi
import me.cafecode.repository.model.Repo
import javax.inject.Inject


open class RepoRepository @Inject constructor(val api: GithubApi) {

    open fun getRepositories(): Flowable<List<Repo>> =
            api.getRepositories().map { it }

    open fun getNextRepositories(since: String): Flowable<List<Repo>> =
            api.getNextPageRepositories(since)
}
