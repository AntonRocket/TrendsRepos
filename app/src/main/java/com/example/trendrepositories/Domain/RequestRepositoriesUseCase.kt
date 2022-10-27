package com.example.trendrepositories.Domain

import com.example.trendrepositories.Data.TrendReposRepository

class RequestRepositoriesUseCase(private val logRepositoriesRepository: TrendReposRepository) {

    fun requestRepositories(trend: String) {
        logRepositoriesRepository.requestRepos(trend)
    }
}