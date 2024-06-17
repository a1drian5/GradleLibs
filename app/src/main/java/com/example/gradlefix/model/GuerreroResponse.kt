package com.example.gradlefix.model


import com.google.gson.annotations.SerializedName

data class GuerreroResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("links")
    val links: Links
)