package com.example.toDoList

import java.util.*

public class Task(_taskName: String, _date: Date) {

    val taskName: String
    val date: Date
    init{
        taskName = _taskName
        date = _date
    }
}