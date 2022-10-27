package com.example.trendrepositories.entity

import androidx.annotation.StringRes
import com.example.trendrepositories.R

enum class Trend(
    @StringRes val titleId: Int,
    val since: String
) {
    DAY(R.string.day, "daily"),
    WEEK(R.string.week, "weekly"),
    MONTH(R.string.month, "monthly");

    companion object {
        fun from(id: Int): Trend {
            return when (id) {
                R.id.day -> DAY
                R.id.week -> WEEK
                else -> MONTH
            }
        }
    }
}