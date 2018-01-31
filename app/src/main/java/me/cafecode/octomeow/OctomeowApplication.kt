package me.cafecode.octomeow

import android.app.Application
import me.cafecode.octomeow.di.AppComponent
import me.cafecode.octomeow.di.AppModule
import me.cafecode.octomeow.di.DaggerAppComponent
import me.cafecode.repository.RepositoryModule


class OctomeowApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule())
                .repositoryModule(RepositoryModule(this))
                .build()
    }

}
