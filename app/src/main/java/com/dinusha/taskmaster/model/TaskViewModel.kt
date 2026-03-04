
/* * --------------------------------------------------------------------------------
 * FILE 2: Task ViewModel (Package: com.dinusha.taskmaster)
 * --------------------------------------------------------------------------------
 */
package com.dinusha.taskmaster

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dinusha.taskmaster.model.Task

// PDF Requirement: State Management (Properly handle screen rotation)
class TaskViewModel : ViewModel() {
    val tasksLiveData = MutableLiveData<MutableList<Task>>(mutableListOf())

    fun setTasks(list: MutableList<Task>) {
        tasksLiveData.value = list
    }

    fun addTask(task: Task) {
        val current = tasksLiveData.value ?: mutableListOf()
        current.add(0, task)
        tasksLiveData.value = current
    }

    fun removeTask(task: Task) {
        val current = tasksLiveData.value ?: mutableListOf()
        current.remove(task)
        tasksLiveData.value = current
    }
}