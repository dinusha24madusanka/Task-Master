package com.dinusha.taskmaster

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dinusha.taskmaster.model.Task
import com.dinusha.taskmaster.service.TaskService

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val taskService = TaskService(this)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etDesc = findViewById<EditText>(R.id.etDesc)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val desc = etDesc.text.toString().trim()

            // [SECURE CODING] - Input Validation
            // පද්ධතියට වැරදි දත්ත ඇතුළත් වීම වැළැක්වීම සඳහා validation සිදු කරයි.
            if (title.isNotEmpty()) {
                val list = taskService.loadTasks()
                list.add(0, Task(System.currentTimeMillis().toString(), title, desc))

                // [DATA PERSISTENCE] - Local storage considerations
                taskService.saveTasks(list)

                Toast.makeText(this, "වැඩේ සුරැකුණා!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "වැඩේ නම ඇතුළත් කරන්න", Toast.LENGTH_SHORT).show()
            }
        }
    }
}