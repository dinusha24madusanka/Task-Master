package com.dinusha.taskmaster

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dinusha.taskmaster.service.TaskService
import com.dinusha.taskmaster.ui.TaskAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var taskService: TaskService
    private lateinit var viewModel: TaskViewModel
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskService = TaskService(this)
        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)

        // දත්ත load කර ViewModel එකට දීම (පළමු වරට පමණක්)
        if (viewModel.tasksLiveData.value.isNullOrEmpty()) {
            viewModel.setTasks(taskService.loadTasks())
        }

        adapter = TaskAdapter(viewModel.tasksLiveData.value ?: mutableListOf()) { task ->
            viewModel.removeTask(task)
            taskService.saveTasks(viewModel.tasksLiveData.value ?: mutableListOf())
        }

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        // ViewModel එකේ වෙනස්කම් නිරීක්ෂණය කර UI එක update කිරීම
        viewModel.tasksLiveData.observe(this) { updatedList ->
            adapter.updateData(updatedList)
        }

        fabAdd.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }
}