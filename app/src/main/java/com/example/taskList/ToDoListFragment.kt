package com.example.taskList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.ToDoListDatabase
import com.example.helpers.TaskAdapter
import com.example.start.R
import com.example.start.databinding.FragmentToDoListBinding
import kotlinx.android.synthetic.main.fragment_task_item.*
import timber.log.Timber


class ToDoListFragment : Fragment(), LifecycleObserver,
    ItemClickListerner {

    lateinit var toDoListViewModel: ToDoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        Timber.i("onCreate called")
    }

    lateinit var binding : FragmentToDoListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_to_do_list, container, false)
        binding.floatingActionButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ToDoListFragmentDirections.actionToDoListFragmentToCreateTaskFragment())
        }


        var application = requireNotNull(this.activity).application
        var dataSource = ToDoListDatabase.getInstance(application).toDoListDatabaseDao()
        val viewModelFactory =
            ToDoListVMFactory(dataSource, application)
        toDoListViewModel = ViewModelProvider(this, viewModelFactory)
            .get(ToDoListViewModel::class.java)
        val adapter : TaskAdapter =
            TaskAdapter(this)

        binding.recyclerview.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = adapter
        binding.viewModel = toDoListViewModel

        toDoListViewModel.addTask()
        toDoListViewModel.tasks.observe(this.viewLifecycleOwner, Observer { newList ->
            newList?.let {
                adapter.submitList(newList)
            }
        })

        var bindingItem = inflater.inflate(R.layout.fragment_task_item, container, false)
        var button = bindingItem.findViewById(R.id.button2) as Button

        button.setOnClickListener {
            Timber.i("setOnClickListener" + it.tag)
            var id : Long = it.tag as Long
            Timber.i("setOnClickListener2" + it.tag)
            toDoListViewModel.deleteTask(id)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun OnClick(str: String) {
        TODO("Not yet implemented")
    }

}

interface ItemClickListerner {
    fun OnClick(str: String)
}