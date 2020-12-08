package com.example.task

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import androidx.lifecycle.*
import com.example.database.Task
import com.example.database.ToDoListDatabaseDao
import com.example.database.asTaskDomainModel
import com.example.repository.TaskRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class TaskViewModel(
    val db : ToDoListDatabaseDao,
    application: Application
) : AndroidViewModel(application){

    val tasks = Transformations.map(db.getAllTasks()) {
        Timber.i("Tasks count: " + it.count().toString())
        it.asTaskDomainModel()
    }
}