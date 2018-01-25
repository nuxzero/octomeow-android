package me.cafecode.octomeow.ui.repolist

import android.support.v7.widget.RecyclerView
import me.cafecode.octomeow.databinding.RepoListItemBinding
import me.cafecode.repository.model.Repo


class RepoListViewHolder(private val binding: RepoListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(repo: Repo) {
        binding.repo = repo
    }
}
