package com.example.trendrepositories.Domain

import com.example.trendrepositories.Presentation.Router

class GetRouterUseCase(private val router: Router) {

    fun openReposUrl(url: String) = router.openReposUrl(url)

}