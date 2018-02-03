package me.cafecode.octomeow

import me.cafecode.octomeow.di.AppModule
import me.cafecode.octomeow.scheduler.BaseScheduler
import me.cafecode.octomeow.scheduler.ImmediateScheduler


class TestAppModule : AppModule() {
    override fun provideScheduler(): BaseScheduler = ImmediateScheduler()
    override fun provideHostName(): String = "api.testgithub.com/"
}
