package com.example.taskList

import android.app.Application
import androidx.lifecycle.*
import com.example.database.ToDoListDatabaseDao
import com.example.database.asTaskDomainModel
import com.example.domain.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class ToDoListViewModel(
    val db : ToDoListDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
    val tasks = Transformations.map(db.getAllTasks()) {
        Timber.i("Tasks count: " + it.count().toString())
        it.asTaskDomainModel()
    }

    lateinit var initList : ArrayList<Task>

    init {
        initList = ArrayList()
    }

    val clearButtonVisible = Transformations.map(tasks) {
        it?.isNotEmpty()
    }

    fun addTask() {
        var task = com.example.database.Task(itemName = "Prepare for the exam", isCompleted = false)
        var task2 = com.example.database.Task(itemName = "Do homework", isCompleted = false)
        var task3 = com.example.database.Task(itemName = "Walk with a dog", isCompleted = false)
        viewModelScope.launch {
            if(db.getAllTasks() == null){
                db.insert(task)
                db.insert(task2)
                db.insert(task3)
            }
        }
    }

    suspend fun clear()
    {
        return withContext(Dispatchers.IO) {
            db.clear()
        }
    }
}