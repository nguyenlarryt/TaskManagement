package com.arynlyre.taskmanagement.domain.repository

import com.arynlyre.taskmanagement.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getTasks(): Flow<List<Task>>
    suspend fun getTask(id: Long): Flow<Task?>

    suspend fun addTask(title: String, desc: String, isCompleted: Boolean)
    suspend fun updateTask(task: Task)

    suspend fun deleteTask(taskId: Long)
    suspend fun deleteAllTasks()
}
