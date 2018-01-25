package me.cafecode.repository.di

import dagger.Component
import me.cafecode.repository.api.GithubApiTest

@Component(modules = [TestRepositoryModule::class])
interface TestRepositoryComponent {

    fun inject(test: GithubApiTest)
}
