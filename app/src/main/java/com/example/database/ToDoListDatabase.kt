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
        private var INSTANCE: ToDoListDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ToDoListDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoListDatabase::class.java,
                    "task_database"
                )

                    .fallbackToDestructiveMigration()
                    .addCallback(TaskDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class TaskDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.toDoListDatabaseDao())
                    }
                }
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
