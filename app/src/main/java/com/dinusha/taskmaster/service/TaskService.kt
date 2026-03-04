package com.dinusha.taskmaster.service

import android.content.Context
import com.dinusha.taskmaster.model.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// PDF Requirement: Data persistence using SharedPreferences.
class TaskService(context: Context) {
    private val prefs = context.getSharedPreferences("TaskMaster_Prefs", Context.MODE_PRIVATE)
    private val gson = Gson()
    private val KEY_TASKS = "saved_tasks"

    fun saveTasks(taskList: List<Task>) {
        val json = gson.toJson(taskList)
        prefs.edit().putString(KEY_TASKS, json).apply()
    }

    fun loadTasks(): MutableList<Task> {
        val json = prefs.getString(KEY_TASKS, null) ?: return mutableListOf()
        val type = object : TypeToken<MutableList<Task>>() {}.type
        return try { gson.fromJson(json, type) } catch (e: Exception) { mutableListOf() }
    }
}