package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.Video


@Entity(tableName = "Task")
data class Task constructor(

    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    @ColumnInfo(name = "itemName")
    val itemName: String,

    @ColumnInfo(name = "isCompleted")
    var isCompleted: Boolean = false
)

@Entity
data class DatabaseVideo constructor(
    @PrimaryKey
    val url: String,
    val updated: String,
    val title: String,
    val description: String,
    val thumbnail: String)

fun List<Task>.asTaskDomainModel(): List<com.example.domain.Task> {
    return map {
        com.example.domain.Task(
            taskId = it.taskId,
            itemName = it.itemName,
            isCompleted = it.isCompleted)
    }
}

fun List<DatabaseVideo>.asVideoDomainModel(): List<Video> {
    return map {
        Video(
            url = it.url,
            title = it.title,
            description = it.description,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }
}
