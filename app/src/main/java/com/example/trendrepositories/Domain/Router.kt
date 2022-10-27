package com.example.trendrepositories.Presentation

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

interface Router{
    fun openReposUrl(url: String)
}

class RouterImpl(private val context: Context): Router{

    override fun openReposUrl(url: String){
        val intent = Intent(context, WebActivity::class.java)
            .putExtra("url", url)
            .setFlags(FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}