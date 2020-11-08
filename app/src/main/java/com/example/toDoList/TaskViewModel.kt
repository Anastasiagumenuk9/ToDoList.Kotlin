package com.example.toDoList

import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel

class TaskViewModel  : ViewModel() {
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