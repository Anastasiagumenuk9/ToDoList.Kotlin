package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Schedule")
data class Schedule (

    @PrimaryKey(autoGenerate = true)
    var scheduleId: Long = 0L,

    @ColumnInfo(name = "itemName")
    val itemName: String,

    @ColumnInfo(name = "isCompleted")
    var isCompleted: Boolean = false
)