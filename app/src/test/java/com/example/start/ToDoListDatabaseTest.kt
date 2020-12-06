package com.example.start

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.database.Schedule
import com.example.database.ToDoListDatabase
import com.example.database.ToDoListDatabaseDao

import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*


@RunWith(AndroidJUnit4::class)
class ToDoListDatabaseTest {

    private lateinit var toDoListDao: ToDoListDatabaseDao
    private lateinit var db: ToDoListDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, ToDoListDatabase::class.java)

            .allowMainThreadQueries()
            .build()
        toDoListDao = db.toDoListDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    suspend fun insertAndGetSchedule() {
        val schedule = Schedule(itemName = "Make title", dateTime = Date())
        toDoListDao.insert(schedule)
        val schedule1 = toDoListDao.getFirst()
        assertEquals(schedule1?.dateTime, -1)
    }
}