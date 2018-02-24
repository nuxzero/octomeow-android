package me.cafecode.octomeow

import me.cafecode.repository.RepositoryModule


class TestApp : OctomeowApplication() {

    lateinit var component: TestAppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerTestAppComponent.builder()
            .appModule(TestAppModule())
            .repositoryModule(RepositoryModule(this))
            .build()
            component.inject(this)
    }
}
