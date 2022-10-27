package com.example.trendrepositories.Presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trendrepositories.Domain.SDK
import com.example.trendrepositories.entity.Trend

class MainViewModel() : ViewModel() {

    private val getTrendsUseCase by lazy { SDK.getTrendUseCase() }
    private val saveSelectedTrendUseCase by lazy { SDK.getSaveSelectedTrendUseCase() }
    private val getRouterUseCase by lazy { SDK.getRouterUseCase()}
    private val getRepositoriesUseCase = SDK.getRepositoriesUseCase()
    private val requestRepositoriesUseCase = SDK.getRequestRepositoriesUseCase()

    val repositoriesLiveData = getRepositoriesUseCase.getRepositoriesLiveData()

    var trendLiveData = MutableLiveData(Trend.MONTH)

    init {
        requestRepositories(getTrendsUseCase.get())
    }

    fun requestRepositories(trendId: Int){
        val trend = Trend.from(trendId)
        trendLiveData.value = trend
        saveSelectedTrendUseCase.save(trendId)
        requestRepositoriesUseCase.requestRepositories(trend.since)
    }

    fun requestRouter(url : String){
        getRouterUseCase.openReposUrl(url)
    }
}
