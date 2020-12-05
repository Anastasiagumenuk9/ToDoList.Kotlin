package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Task (

    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    @ColumnInfo(name = "itemName")
    val itemName: String,

    @ColumnInfo(name = "isCompleted")
    var isCompleted: Boolean = false
)

fun List<Task>.asDomainModel(): List<Task> {
    return map {
        Task(
            taskId = it.taskId,
            itemName = it.itemName,
            isCompleted = it.isCompleted)
    }
}