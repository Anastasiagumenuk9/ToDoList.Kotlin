package com.example.network

import com.example.database.Task
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ToDoListContainer(val notes: List<NetworkTask>)

@JsonClass(generateAdapter = true)
data class NetworkTask(
    val taskId : Long,
    val itemName : String,
    val isCompleted : Boolean)


fun ToDoListContainer.asDatabaseModel(): Array<Task> {
    return notes.map {
        Task (
            taskId = it.taskId,
            itemName = it.itemName,
            isCompleted = it.isCompleted)
    }.toTypedArray()
}

fun ToDoListContainer.asDomainModel(): List<Task> {
    return notes.map {
        Task(
            taskId = it.taskId,
            itemName = it.itemName,
            isCompleted = it.isCompleted)
    }
}
