package com.example.trendrepositories.Presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trendrepositories.R

class RepositoryViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val context = view.context
    val tvName = view.findViewById<TextView>(R.id.tv_name)
    val tvDescription = view.findViewById<TextView>(R.id.tv_description)
    val tvNameOwner = view.findViewById<TextView>(R.id.tv_nameOwner)
    val imUserAvatar = view.findViewById<ImageView>(R.id.user_avatar)
}