package com.example.toDoList

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_task.*


class CreateTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        calendarView1.visibility = View.INVISIBLE
//
//        calendarView1.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            edit_date.setText("$dayOfMonth.${month + 1}.$year")
//        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_task, container, false)
    }

//    fun addDate_onButtonClick(view: View) {
//
//        if (calendarView1.visibility == View.INVISIBLE) {
//
//            calendarView1.visibility = View.VISIBLE
//        }
//        else {
//            calendarView1.visibility = View.INVISIBLE
//        }
//    }
//
//    fun addTask_onButtonClick(view: View) {
//        if (edit_message.text.trim().length != 0) {
//            val message = edit_message.text.toString()
//            edit_message.setText("")
//            edit_date.setText("")
//            calendarView1.visibility = View.INVISIBLE
//            Toast.makeText(
//                activity, message + "  added to tasks list",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        else{
//            Toast.makeText(
//                activity, "Error: create task, please",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
}