package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.database.ToDoListDatabase
import com.example.database.asDomainModel
import com.example.domain.Video
import com.example.network.Network
import com.example.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideosRepository(private val database: ToDoListDatabase) {

    val videos: LiveData<List<Video>> =
        Transformations.map(database.toDoListDatabaseDao.getVideos()) {
            it.asDomainModel()
        }

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = Network.devbytes.getPlaylist().await()
            database.toDoListDatabaseDao.insertAllVideos(*playlist.asDatabaseModel())
        }
    }
}