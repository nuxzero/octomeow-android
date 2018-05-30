package me.cafecode.octomeow

import dagger.Component
import dagger.android.AndroidInjectionModule
import me.cafecode.octomeow.di.ActivityBuilder
import me.cafecode.octomeow.di.AppComponent
import me.cafecode.octomeow.di.AppModule
import me.cafecode.octomeow.ui.repolist.RepoListFragmentTest
import me.cafecode.octomeow.viewmodel.ViewModelModule
import me.cafecode.repository.RepositoryModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBuilder::class,
    AppModule::class,
    ViewModelModule::class,
    RepositoryModule::class])
interface TestAppComponent : AppComponent {
    fun inject(app: TestApp)
    fun inject(test: RepoListFragmentTest)
}
