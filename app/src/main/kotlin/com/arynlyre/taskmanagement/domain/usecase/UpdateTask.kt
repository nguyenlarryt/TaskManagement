package com.arynlyre.taskmanagement.domain.usecase

import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.repository.TaskRepository

fun interface UpdateTask {
    suspend operator fun invoke(task: Task)
}

suspend fun updateTask(task: Task, taskRepository: TaskRepository) = taskRepository.updateTask(task)
