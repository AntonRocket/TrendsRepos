package com.example.trendrepositories.Data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.trendrepositories.Model.Repository
import com.example.trendrepositories.entity.LanguageType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface TrendReposRepository {
    fun requestRepos(trend: String)
    fun repositoriesLiveData(): LiveData<List<Repository>>
}

data class TrendReposRepositoryImpl(
    private val ghRepository: GitHubRepository
) : TrendReposRepository {
    private val listRepositoryLiveData = MutableLiveData<List<Repository>>()

    override fun repositoriesLiveData(): LiveData<List<Repository>> = listRepositoryLiveData

    override fun requestRepos(trend: String) = ghRepository
        .getRepositories(LanguageType.KOTLIN.label, trend)
        .enqueue(object : Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                listRepositoryLiveData.value = response.body() ?: emptyList()
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Log.e("Error", t.toString())
            }

        })
}