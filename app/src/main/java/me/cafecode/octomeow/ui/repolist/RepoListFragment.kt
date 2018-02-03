package me.cafecode.octomeow.ui.repolist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import me.cafecode.octomeow.OctomeowApplication
import me.cafecode.octomeow.R
import me.cafecode.octomeow.databinding.RepoListFragmentBinding
import me.cafecode.octomeow.model.ObservingResult
import me.cafecode.octomeow.ui.base.BaseFragment
import me.cafecode.repository.model.Repo
import javax.inject.Inject

class RepoListFragment : BaseFragment() {

    private var listener: OnFragmentInteractionListener? = null
    lateinit var binding: RepoListFragmentBinding
    lateinit var viewModel: RepoListViewModel
    private val adapter: RepoListAdapter by lazy { RepoListAdapter() }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.repo_list_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(RepoListViewModel::class.java)
        binding.repoList.layoutManager = LinearLayoutManager(context)
        binding.repoList.adapter = adapter

        if (savedInstanceState == null) {
            viewModel.refreshRepos()
        }

        viewModel.reposData.observe(this, Observer { result ->
            when (result) {
                is ObservingResult.Loading<List<Repo>> -> Toast.makeText(context, "Start loading...", Toast.LENGTH_SHORT).show()
                is ObservingResult.Success<List<Repo>> -> adapter.repos = result.data
                is ObservingResult.Failure -> Toast.makeText(context, result.error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }
}
