package com.example.trendrepositories.Presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.trendrepositories.Model.Repository

class DiffCallback : DiffUtil.ItemCallback<Repository>() {

    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem == newItem
    }
}

