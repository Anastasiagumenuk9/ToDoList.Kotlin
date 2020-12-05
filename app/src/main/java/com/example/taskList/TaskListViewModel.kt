package com.example.taskList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.database.ToDoListDatabaseDao

class TaskListViewModel(
    val database: ToDoListDatabaseDao,
    application: Application
) : AndroidViewModel(application) {


}