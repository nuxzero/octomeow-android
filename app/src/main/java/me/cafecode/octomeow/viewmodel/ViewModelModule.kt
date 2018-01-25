package me.cafecode.octomeow.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.cafecode.octomeow.ui.repolist.RepoListViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel::class)
    abstract fun bindRepoListViewModel(viewModel: RepoListViewModel): ViewModel

}
