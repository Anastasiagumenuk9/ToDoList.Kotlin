package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.helpers.Converters

@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(*[Converters::class])
abstract class ToDoListDatabase : RoomDatabase() {

    abstract val toDoListDatabaseDao: ToDoListDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: ToDoListDatabase? = null


        fun getInstance(context: Context): ToDoListDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoListDatabase::class.java,
                        "sleep_history_database"
                    )

                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}