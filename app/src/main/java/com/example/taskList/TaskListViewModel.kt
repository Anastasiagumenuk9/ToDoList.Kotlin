package com.example.taskList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.database.ToDoListDatabaseDao

class TaskListViewModel(
    val database: ToDoListDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    fun GetAllTasks(): LiveData<List<String>> {
        return database.getScheduleItems()
    }

}