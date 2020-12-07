package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoListDatabaseDao {

    @Insert
    suspend fun insert(schedule: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTasks(vararg tasks: Task)

    @Update
    suspend fun update(schedule: Task)

    @Query("DELETE FROM task")
    suspend fun deleteAllTasks()

    @Query("SELECT * from Task WHERE taskId = :key")
    suspend fun get(key: Long): Task?

    @Query("DELETE FROM Task")
    suspend fun clear()

    @Query("SELECT * FROM Task ORDER BY taskId DESC")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("SELECT itemName FROM Task ORDER BY taskId DESC")
    fun getScheduleItems(): LiveData<List<String>>

    @Query("SELECT * FROM Task ORDER BY taskId DESC LIMIT 1")
    suspend fun getFirst(): Task?

    @Query("select * from databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllVideos(vararg videos: DatabaseVideo)
}
