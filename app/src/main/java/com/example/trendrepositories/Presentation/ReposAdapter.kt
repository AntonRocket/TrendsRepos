package com.example.trendrepositories.Presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trendrepositories.Model.Repository
import com.example.trendrepositories.R
import com.squareup.picasso.Picasso

class ReposAdapter : ListAdapter<Repository, RepositoryViewHolder>(DiffCallback()) {

    var onRepositoryClickListener: ((Repository) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layout = R.layout.list_item_repository
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layout, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RepositoryViewHolder, position: Int) {
        val repository = getItem(position)
        val repositoryString = viewHolder.context.getString(R.string.repositories)
        val ownerString = viewHolder.context.getString(R.string.owner)

        viewHolder.tvName.text = "${repositoryString} ${repository.name}"
        viewHolder.tvDescription.text = repository.description

        val owner = repository.owners.firstOrNull()
        viewHolder.tvNameOwner.text = "${ownerString} ${owner?.name}"
        Picasso.get().load("${owner?.avatarUrl}").into(viewHolder.imUserAvatar);

        viewHolder.view.setOnClickListener {
            onRepositoryClickListener?.invoke(repository)
        }
    }
}
