package com.example.trendrepositories

import android.app.Application
import com.example.trendrepositories.Domain.SDK

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SDK.initTrendRepository(applicationContext)
        SDK.initRouter(applicationContext)
    }

}