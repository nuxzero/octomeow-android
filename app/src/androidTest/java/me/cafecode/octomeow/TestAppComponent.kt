package me.cafecode.octomeow

import dagger.Component
import me.cafecode.octomeow.di.AppComponent
import me.cafecode.octomeow.di.AppModule
import me.cafecode.octomeow.ui.repolist.RepoListFragmentTest
import me.cafecode.octomeow.viewmodel.ViewModelModule
import me.cafecode.repository.RepositoryModule
import javax.inject.Singleton


@Component(modules = [AppModule::class, ViewModelModule::class, RepositoryModule::class])
@Singleton
interface TestAppComponent : AppComponent {
    fun inject(fragmentTest: RepoListFragmentTest)
}
