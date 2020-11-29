package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoListDatabaseDao {

    @Insert
    suspend fun insert(schedule: Schedule)

    @Update
    suspend fun update(schedule: Schedule)

    @Query("SELECT * from Schedule WHERE scheduleId = :key")
    suspend fun get(key: Long): Schedule?

    @Query("DELETE FROM Schedule")
    suspend fun clear()

    @Query("SELECT * FROM Schedule ORDER BY scheduleId DESC")
    fun getAllSchedules(): LiveData<List<Schedule>>

    @Query("SELECT * FROM Schedule ORDER BY scheduleId DESC LIMIT 1")
    suspend fun getFirst(): Schedule?
}