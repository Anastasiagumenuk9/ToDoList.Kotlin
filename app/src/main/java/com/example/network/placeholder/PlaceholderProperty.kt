package com.example.network.placeholder

import com.squareup.moshi.Json

data class PlaceholderProperty(
    val taskId: Long,
    val itemName: String,
    val isCompleted: Boolean,
    @Json(name = "url") val url: String,
    @Json(name = "thumbnailUrl") val thumbnailUrl: String
)