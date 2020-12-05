package com.example.taskList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.database.ToDoListDatabase
import com.example.helpers.MyListAdapter
import com.example.start.R


class ToDoListFragment : Fragment() {

    private lateinit var viewModel: TaskListViewModel
    private lateinit var taskList : LiveData<List<String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: com.example.start.databinding.FragmentToDoListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_to_do_list, container, false
        )
        binding.floatingActionButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ToDoListFragmentDirections.actionToDoListFragmentToCreateTaskFragment())
        }
        var application = requireNotNull(this.activity).application
        var dataSource = ToDoListDatabase.getInstance(application).toDoListDatabaseDao

        val viewModelFactory = TaskListVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TaskListViewModel::class.java)

        val listView: ListView? = container?.findViewById(R.id.listView)
        taskList = viewModel.GetAllTasks()
        //val arrayAdapter: ArrayAdapter<*>
        //var arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList)
        /*arrayAdapter = MyListAdapter(this, taskList, taskList)
        listView?.adapter = arrayAdapter*/



        setHasOptionsMenu(true)
        return binding.root
    }
}