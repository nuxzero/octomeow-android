package me.cafecode.octomeow.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import me.cafecode.octomeow.R
import me.cafecode.octomeow.ui.repodetail.RepoDetailFragment
import me.cafecode.octomeow.ui.repolist.RepoListFragment
import me.cafecode.repository.model.Repo

class MainActivity : AppCompatActivity(), RepoListFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            val fragment = RepoListFragment()
            fragment.listener = this
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content_layout, fragment)
                    .commit()
        }
    }

    override fun onRepoItemClickListener(repo: Repo) {
        Log.d("Repo", repo.fullName)
        val fragment = RepoDetailFragment.newInstance(repo)
        replaceFragment(fragment)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_layout, fragment)
            .commit()
    }
}
