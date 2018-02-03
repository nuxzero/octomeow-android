package me.cafecode.octomeow.di

import dagger.Module
import dagger.Provides
import me.cafecode.octomeow.scheduler.BaseScheduler
import me.cafecode.octomeow.scheduler.Scheduler
import javax.inject.Singleton

@Module
open class AppModule {

    @Provides
    @Singleton
    open fun provideScheduler(): BaseScheduler = Scheduler()

    @Provides
    @Singleton
    open fun provideHostName(): String = "api.github.con/"
}
