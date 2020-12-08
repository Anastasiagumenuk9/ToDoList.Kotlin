package com.example.helpers

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Task
import  com.example.start.databinding.FragmentTaskItemBinding
import com.example.taskList.ItemClickListerner

class TaskAdapter(val itemClickListerner: ItemClickListerner) : ListAdapter<Task, TaskAdapter.TaskHolder>(
    TaskDiffCallback()
) {

    class TaskHolder(val binding: FragmentTaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        lateinit var itemName : TextView

        init {
            itemName = binding.textView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentTaskItemBinding.inflate(layoutInflater, parent, false)
        return TaskHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val value : Task = getItem(position)
        holder.binding.task = value
        holder.binding.executePendingBindings()

    }
}
class TaskDiffCallback : DiffUtil.ItemCallback<com.example.domain.Task>() {
    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.taskId == newItem.taskId
    }
}
