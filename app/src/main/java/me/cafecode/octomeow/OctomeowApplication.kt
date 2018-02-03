package me.cafecode.octomeow

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import me.cafecode.octomeow.di.AppModule
import me.cafecode.octomeow.di.DaggerAppComponent
import me.cafecode.repository.RepositoryModule
import javax.inject.Inject


open class OctomeowApplication :
        Application(),
        HasActivityInjector,
        HasSupportFragmentInjector {

    @Inject lateinit var dispatchingActivityAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var  dispatchingFragmentAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appModule(AppModule())
                .repositoryModule(RepositoryModule(this))
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityAndroidInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingFragmentAndroidInjector
}
