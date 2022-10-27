package com.example.trendrepositories.Model

import com.google.gson.annotations.SerializedName

data class Repository(
    val url: String,
    val name: String,
    val description: String,
    @SerializedName ("builtBy")
    val owners: List<Owner>
)

data class Owner(
    @SerializedName ("username")
    val name: String,
    @SerializedName ("avatar")
    val avatarUrl: String
)