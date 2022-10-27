package com.example.trendrepositories.Domain

import android.content.Context
import com.example.trendrepositories.Data.RetrofitClient
import com.example.trendrepositories.Data.TrendReposRepositoryImpl
import com.example.trendrepositories.Presentation.RouterImpl

object SDK {

    private lateinit var _trendRepository: TrendRepositoryImpl
    private lateinit var _routerRepository: RouterImpl
    private val _trendReposRepository = TrendReposRepositoryImpl(RetrofitClient.gitHubRepository)

    fun getTrendUseCase() = GetTrendsUseCase(_trendRepository)

    fun getRepositoriesUseCase() = GetRepositoriesUseCase(_trendReposRepository)

    fun getSaveSelectedTrendUseCase() = SaveSelectedTrendUseCase(_trendRepository)

    fun getRequestRepositoriesUseCase() = RequestRepositoriesUseCase(_trendReposRepository)

    fun initTrendRepository(context: Context) {
        _trendRepository = TrendRepositoryImpl(context)
    }

    fun initRouter(context: Context) {
        _routerRepository = RouterImpl(context)
    }

    fun getRouterUseCase() = GetRouterUseCase(_routerRepository)

}