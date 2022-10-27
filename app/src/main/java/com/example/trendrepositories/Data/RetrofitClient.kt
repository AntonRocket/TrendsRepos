package com.example.trendrepositories.Data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val RAPID_HOST = "github-trending.p.rapidapi.com"
    private const val RAPID_API_KEY = "ab51fc7281mshd0a7c4f145fc2bcp198577jsn3ef36493d476"

    private const val BASE_URL = "https://github-trending.p.rapidapi.com"

    private val client = OkHttpClient().newBuilder().apply {
        addInterceptor {
            it.proceed(
                it.request().newBuilder().apply {
                    addHeader("X-RapidAPI-Host", RAPID_HOST)
                    addHeader("X-RapidAPI-Key", RAPID_API_KEY)
                }.build()
            )
        }
    }.build()

    private var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val gitHubRepository: GitHubRepository = retrofit
        .create(GitHubRepository::class.java)
}