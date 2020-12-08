package com.example.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.database.Task
import com.example.database.ToDoListDatabaseDao
import com.example.database.asTaskDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class TaskRepository(private val archiveDao: ToDoListDatabaseDao) {

    val tasks: LiveData<List<com.example.domain.Task>> = Transformations.map(archiveDao.getAllTasks()) {
        it.asTaskDomainModel()
    }
}