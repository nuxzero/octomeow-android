package me.cafecode.octomeow.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import me.cafecode.octomeow.OctomeowApplication
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
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: OctomeowApplication)
}
