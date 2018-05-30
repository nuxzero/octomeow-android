package me.cafecode.octomeow.ui.repolist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.cafecode.octomeow.R
import me.cafecode.octomeow.databinding.RepoListItemBinding
import me.cafecode.octomeow.ui.common.OnClickListener
import me.cafecode.repository.model.Repo


class RepoListAdapter(val clickListener: OnClickListener<Repo>) : RecyclerView.Adapter<RepoListViewHolder>() {

    var repos: List<Repo>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoListViewHolder {
        val itemBinding = DataBindingUtil.inflate<RepoListItemBinding>(LayoutInflater.from(parent!!.context), R.layout.repo_list_item, parent, false)
        itemBinding.clickListener = clickListener
        return RepoListViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = repos?.size ?: 0

    override fun onBindViewHolder(holder: RepoListViewHolder?, position: Int) {
        repos?.get(position)?.let { holder?.bind(it) }
    }

}
