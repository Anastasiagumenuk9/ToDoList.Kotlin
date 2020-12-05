package com.example.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.database.ToDoListDatabase
import com.example.start.R


class CreateTaskFragment : Fragment() {

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var application = requireNotNull(this.activity).application
        var dataSource = ToDoListDatabase.getInstance(application).toDoListDatabaseDao

        val viewModelFactory = TaskVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TaskViewModel::class.java)

        return inflater.inflate(R.layout.fragment_create_task, container, false)
    }
}