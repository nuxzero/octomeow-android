package me.cafecode.octomeow.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.cafecode.octomeow.R
import me.cafecode.octomeow.ui.repolist.RepoListFragment

class MainActivity : AppCompatActivity(), RepoListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content_layout, RepoListFragment())
                    .commit()
        }
    }

    override fun onFragmentInteraction() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
