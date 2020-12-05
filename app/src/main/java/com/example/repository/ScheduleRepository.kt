package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.database.Task
import com.example.database.ToDoListDatabaseDao
import com.example.database.asDomainModel
import com.example.network.ToDoListApiApi
import com.example.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleRepository(private val toDoListDao: ToDoListDatabaseDao) {

    val archiveNotes: LiveData<List<Task>> = Transformations.map(toDoListDao.getAllSchedules()) {
        it.asDomainModel()
    }

    suspend fun refreshTasks() {
        withContext(Dispatchers.IO){
            val list = ToDoListApiApi.retrofitService.getList()
            toDoListDao.insertAll(*list.asDatabaseModel())
        }
    }
}