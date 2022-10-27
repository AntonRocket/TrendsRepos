package com.example.trendrepositories.Domain

class SaveSelectedTrendUseCase(private val trendRepository: TrendRepository) {

    fun save(threadId: Int) = trendRepository.set(threadId)

}