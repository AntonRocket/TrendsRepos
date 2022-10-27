package com.example.trendrepositories.Domain

import androidx.lifecycle.LiveData
import com.example.trendrepositories.Data.TrendReposRepository
import com.example.trendrepositories.Model.Repository

class GetRepositoriesUseCase(private val logRepositoriesRepository: TrendReposRepository){

    fun getRepositoriesLiveData(): LiveData<List<Repository>> {
        return logRepositoriesRepository.repositoriesLiveData()
    }
}