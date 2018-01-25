package me.cafecode.octomeow.di

import dagger.Component
import me.cafecode.octomeow.ui.main.MainActivity
import me.cafecode.octomeow.ui.repolist.RepoListFragment
import me.cafecode.octomeow.viewmodel.ViewModelModule
import me.cafecode.repository.di.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: RepoListFragment)
}
