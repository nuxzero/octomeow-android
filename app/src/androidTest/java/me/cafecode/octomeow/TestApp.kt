package me.cafecode.octomeow

import me.cafecode.repository.RepositoryModule


class TestApp : OctomeowApplication() {

    override fun onCreate() {
        super.onCreate()
        DaggerTestAppComponent.builder()
                .appModule(TestAppModule())
                .repositoryModule(RepositoryModule(this))
                .build()
                .inject(this)
    }
}
