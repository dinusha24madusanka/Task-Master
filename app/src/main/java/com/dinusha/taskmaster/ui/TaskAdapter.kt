package com.dinusha.taskmaster.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dinusha.taskmaster.R
import com.dinusha.taskmaster.model.Task

class TaskAdapter(
    private var tasks: MutableList<Task>,
    private val onDelete: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTaskTitle)
        val desc: TextView = view.findViewById(R.id.tvTaskDesc)
        val deleteBtn: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.title.text = task.title
        holder.desc.text = task.description
        holder.deleteBtn.setOnClickListener { onDelete(task) }
    }

    override fun getItemCount() = tasks.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newTasks: MutableList<Task>) {
        this.tasks = newTasks
        notifyDataSetChanged()
    }
}