package com.example.toDoList

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.database.ToDoListDatabaseDao

class TaskViewModel(val db : ToDoListDatabaseDao, application: Application) : AndroidViewModel(application)
 {
    init {
        Log.i("GameViewModel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    fun addDate_onButtonClick(view: View, calendarView: CalendarView) {

        if (calendarView.visibility == View.INVISIBLE) {

            calendarView.visibility = View.VISIBLE
        }
        else {
            calendarView.visibility = View.INVISIBLE
        }
    }

    fun addTask_onButtonClick(view: View, edit_message: EditText, edit_date: EditText, calendarView: CalendarView) {
        if (edit_message.text.trim().isNotEmpty()) {
            val message = edit_message.text.toString()
            edit_message.setText("")
            edit_date.setText("")
            calendarView.visibility = View.INVISIBLE
        }
    }
}