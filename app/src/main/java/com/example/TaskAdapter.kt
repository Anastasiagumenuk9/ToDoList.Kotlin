package com.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.database.Task
import com.example.start.R

private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1

class TaskAdapter(val clickListener: TaskListener) : ListAdapter<DataItem,
        RecyclerView.ViewHolder>(TaskDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType ${viewType}")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val taskItem = getItem(position) as DataItem.TaskItem
                holder.bind(clickListener, taskItem.task)
            }
        }
    }

}

class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
    companion object {
        fun from(parent: ViewGroup): TextViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.fragment_create_task, parent, false)
            return TextViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ViewHolder.DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is ViewHolder.DataItem.TaskItem -> ITEM_VIEW_TYPE_ITEM
        }
    }
}

class ViewHolder private constructor(val binding: ListItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(clickListener: TaskListener, item: Task) {
        binding.task = item
        binding.clickListener = clickListener
        binding.executePendingBindings()

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class TaskDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

class TaskListener(val clickListener: (id: Long) -> Unit) {
    fun onClick(task: Task) = clickListener(task.taskId)
}

sealed class DataItem {
    data class TaskItem(val task: Task): DataItem() {
        override val id = task.taskId
    }

    object Header: DataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}