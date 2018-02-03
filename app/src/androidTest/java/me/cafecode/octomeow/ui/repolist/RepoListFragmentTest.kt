package me.cafecode.octomeow.ui.repolist

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import me.cafecode.octomeow.TestApp
import me.cafecode.octomeow.TestAppComponent
import me.cafecode.octomeow.ui.main.MainActivity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class RepoListFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Inject
    lateinit var hostname: String

    @Before
    fun setUp() {
        val app = (InstrumentationRegistry.getTargetContext().applicationContext as TestApp)
        (app.component as TestAppComponent)
                .inject(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun checkHostName() {
        assertEquals("api.testgithub.com/", hostname)
    }
}
