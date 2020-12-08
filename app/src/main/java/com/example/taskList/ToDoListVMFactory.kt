package com.example.taskList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.database.ToDoListDatabaseDao
import java.lang.IllegalArgumentException

class ToDoListVMFactory(
    private val dataSource: ToDoListDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoListViewModel::class.java))
            return ToDoListViewModel(
                dataSource,
                application
            ) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}