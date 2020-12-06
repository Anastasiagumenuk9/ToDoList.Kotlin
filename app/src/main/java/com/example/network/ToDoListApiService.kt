package com.example.network

import com.example.network.placeholder.PlaceholderProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ToDoListApiService {
    @GET("albums/1/photos")
    fun getPropertiesAsync():
        Deferred<List<PlaceholderProperty>>
    @GET("getlist")
    suspend fun getList() : ToDoListContainer
}

object ToDoListApi {
    val retrofitService : ToDoListApiService by lazy { retrofit.create(ToDoListApiService::class.java) }
}