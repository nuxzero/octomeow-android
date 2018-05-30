package me.cafecode.octomeow.ui.repolist

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import me.cafecode.octomeow.R
import me.cafecode.octomeow.TestApp
import me.cafecode.octomeow.ui.main.MainActivity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class RepoListFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Inject
    lateinit var hostname: String

    @Mock
    lateinit var viewModel: RepoListViewModel

    lateinit var fragment: RepoListFragment

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        (activityRule.activity.application as TestApp).component.inject(this)
        fragment = RepoListFragment()
        fragment.viewModel = viewModel
        activityRule.activity.replaceFragment(fragment)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun checkHostName() {
        onView(withId(R.id.repo_list)).check(matches(isDisplayed()))
        assertEquals("api.testgithub.com/", fragment.hostname)
        assertEquals("api.testgithub.com/", hostname)
    }

    @Test
    fun loadRepoList() {
    }
}
