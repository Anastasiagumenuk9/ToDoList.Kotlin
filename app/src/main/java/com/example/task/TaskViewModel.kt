package com.example.task

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import com.example.database.ToDoListDatabaseDao

class TaskViewModel(val db : ToDoListDatabaseDao, application: Application) : AndroidViewModel(application)
 {
    init {
        Log.i("GameViewModel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}