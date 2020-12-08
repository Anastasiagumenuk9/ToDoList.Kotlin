package com.example.task

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.database.ToDoListDatabaseDao
import com.example.repository.TaskRepository
import java.lang.IllegalArgumentException

class TaskVMFactory(
    private val dataSource: ToDoListDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(
                dataSource,
                application
            ) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}