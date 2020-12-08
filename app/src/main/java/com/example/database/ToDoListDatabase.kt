package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Task::class, DatabaseVideo::class], version = 1)
abstract class ToDoListDatabase : RoomDatabase() {

    abstract fun toDoListDatabaseDao(): ToDoListDatabaseDao

    companion object {
        @Volatile
        private lateinit var INSTANCE : ToDoListDatabase
        fun getInstance(context: Context) : ToDoListDatabase {
            synchronized(ToDoListDatabase::class.java) {

                if (! ::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoListDatabase::class.java,
                        "task_database"
                    ).fallbackToDestructiveMigration().build()
                }
                return INSTANCE
            }
        }

        suspend fun populateDatabase(toDoListDatabaseDao: ToDoListDatabaseDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            toDoListDatabaseDao.deleteAllTasks()

            var task = Task(itemName = "kozi", isCompleted = false)
            toDoListDatabaseDao.insert(task)
            task = Task(itemName = "kozi", isCompleted = false)
            toDoListDatabaseDao.insert(task)
        }
    }
}
