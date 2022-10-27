package com.example.trendrepositories.Domain

class GetTrendsUseCase(private val trendRepository: TrendRepository) {

    fun get(): Int = trendRepository.get()

}