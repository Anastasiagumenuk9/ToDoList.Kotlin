package com.example.start

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.database.ToDoListDatabaseDao

class StartVMFactory(dataSource: ToDoListDatabaseDao, application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StartViewModel::class.java)) {
            return StartViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}