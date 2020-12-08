package com.example.domain

import com.example.util.smartTruncate

data class Video(val title: String,
                 val description: String,
                 val url: String,
                 val updated: String,
                 val thumbnail: String) {

    val shortDescription: String
        get() = description.smartTruncate(200)
}

data class Task(
    val taskId: Long = 0L,
    val itemName: String,
    val isCompleted: Boolean = false
)
