package me.cafecode.octomeow.di

import dagger.Component
import me.cafecode.octomeow.viewmodel.ViewModelModule
import me.cafecode.repository.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [TestModule::class, ViewModelModule::class, RepositoryModule::class])
open interface TestComponent: AppComponent {

}
