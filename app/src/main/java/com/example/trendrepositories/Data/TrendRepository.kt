package com.example.trendrepositories.Domain

import android.content.Context
import android.content.SharedPreferences

interface TrendRepository {
    fun set(threadId: Int)
    fun get(): Int
}

class TrendRepositoryImpl(private val context: Context) : TrendRepository {

    companion object {
        private const val TREND = "trend"
    }

    private val sharedPref: SharedPreferences = context
        .getSharedPreferences("test", Context.MODE_PRIVATE)

    override fun set(threadId: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(TREND, threadId)
        editor.apply()
    }

    override fun get(): Int = sharedPref.getInt(TREND, -1)

}