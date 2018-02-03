package me.cafecode.octomeow.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.cafecode.octomeow.ui.base.BaseFragment
import me.cafecode.octomeow.ui.main.MainActivity
import me.cafecode.octomeow.ui.repolist.RepoListFragment


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    abstract fun bindRepoListFragment(): RepoListFragment
}
