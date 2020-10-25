package com.example.toDoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController


class ToDoListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: com.example.toDoList.databinding.FragmentToDoListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_to_do_list, container, false)
        binding.floatingActionButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ToDoListFragmentDirections.actionToDoListFragmentToCreateTaskFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}