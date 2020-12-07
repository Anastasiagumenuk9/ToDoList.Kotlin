package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.helpers.Converters

@Database(entities = [Task::class, DatabaseVideo::class], version = 1, exportSchema = false)
@TypeConverters(*[Converters::class])
abstract class ToDoListDatabase : RoomDatabase() {

    abstract val toDoListDatabaseDao: ToDoListDatabaseDao

    companion object {

        @Volatile
        private lateinit var INSTANCE: ToDoListDatabase

        fun getInstance(context: Context): ToDoListDatabase {
            synchronized(ToDoListDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ToDoListDatabase::class.java,
                        "ToDoListDatabase").build()
                }
            }
            return INSTANCE
        }
    }
}