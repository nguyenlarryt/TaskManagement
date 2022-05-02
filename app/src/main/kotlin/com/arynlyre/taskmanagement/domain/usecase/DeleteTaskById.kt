package com.arynlyre.taskmanagement.domain.usecase

import com.arynlyre.taskmanagement.domain.repository.TaskRepository

fun interface DeleteTaskById {
    suspend operator fun invoke(taskId: Long)
}

suspend fun deleteTaskById(taskId: Long, taskRepository: TaskRepository) {
    taskRepository.deleteTask(taskId)
}
