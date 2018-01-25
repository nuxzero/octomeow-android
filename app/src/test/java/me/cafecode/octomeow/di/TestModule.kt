package me.cafecode.octomeow.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestModule : AppModule() {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

}
