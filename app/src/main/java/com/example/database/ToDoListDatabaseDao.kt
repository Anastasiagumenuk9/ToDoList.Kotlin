package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoListDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Query("DELETE FROM task")
    suspend fun deleteAllTasks()

    @Query("SELECT * from Task WHERE taskId = :key")
    suspend fun get(key: Long): Task?

    @Query("DELETE FROM Task")
    suspend fun clear()

    @Transaction
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
