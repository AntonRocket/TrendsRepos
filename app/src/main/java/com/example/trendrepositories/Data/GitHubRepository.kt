package com.example.trendrepositories.Data

import com.example.trendrepositories.Model.Repository
import retrofit2.Call
import retrofit2.http.*

interface GitHubRepository {
    @GET("repositories/")
    fun getRepositories(
        @Query("language") language: String,
        @Query("since") trend: String
    ): Call<List<Repository>>
}