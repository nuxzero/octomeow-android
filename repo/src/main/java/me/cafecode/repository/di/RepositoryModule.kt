package me.cafecode.repository.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import me.cafecode.repository.api.GithubApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
open class RepositoryModule(app: Application) {

    @Singleton
    @Provides
    open fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    open fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    open fun provideGithubApi(): GithubApi = provideRetrofit().create(GithubApi::class.java)

}
