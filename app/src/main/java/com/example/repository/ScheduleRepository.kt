package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.database.Task
import com.example.database.ToDoListDatabaseDao
import com.example.database.asDomainModel
import com.example.network.ToDoListApi
import com.example.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleRepository(private val toDoListDao: ToDoListDatabaseDao) {

    /*val Tasks: LiveData<List<Task>> = Transformations.map(toDoListDao.getAllSchedules()) {
        it.asDomainModel()
    }

    suspend fun refreshTasks() {
        withContext(Dispatchers.IO){
            val list = ToDoListApi.retrofitService.getList()
            toDoListDao.insertAll(*list.asDatabaseModel())
        }
    }*/
}