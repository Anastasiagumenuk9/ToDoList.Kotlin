package com.example.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.database.Task
import com.example.database.ToDoListDatabaseDao
import kotlinx.coroutines.flow.Flow


class TaskRepository(private val toDoListDatabaseDao: ToDoListDatabaseDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allTasks: LiveData<List<Task>> = toDoListDatabaseDao.getAllTasks()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(task: Task) {
        toDoListDatabaseDao.insert(task)
    }
}