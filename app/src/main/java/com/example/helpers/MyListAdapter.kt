package com.example.helpers

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.LiveData
import com.example.start.R
import com.example.taskList.ToDoListFragment

class MyListAdapter(private val context: ToDoListFragment, private val title: List<String>, private val description: List<String>)
    /*: ArrayAdapter<String>(context, R.layout.fragment_task_item, title)*/ {

    /*override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.fragment_task_item, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView

        titleText.text = title[position]

        return rowView
    }*/
}