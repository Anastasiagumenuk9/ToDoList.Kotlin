package com.example.start

import android.app.Application
import com.example.database.ToDoListDatabase
import com.example.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber

class PusherApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ToDoListDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { TaskRepository(database.toDoListDatabaseDao()) }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}