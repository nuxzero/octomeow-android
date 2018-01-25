package me.cafecode.repository.api

import io.reactivex.Flowable
import me.cafecode.repository.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApi {

    @GET("repositories")
    fun getRepositories(): Flowable<List<Repo>>

    @GET("repositories")
    fun getNextPageRepositories(@Query("since") since: String): Flowable<List<Repo>>

    @GET("repos/{user}/{name}")
    fun getRepository(@Path("user") user: String, @Path("name") name: String): Flowable<Repo>
}
