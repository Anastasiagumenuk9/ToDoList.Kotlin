package com.example.network.placeholder

import com.squareup.moshi.Json

data class PlaceholderProperty(
    val albumId: Int,
    val id: Int,
    val title: String,
    @Json(name = "url") val url: String,
    @Json(name = "thumbnailUrl") val thumbnailUrl: String
)