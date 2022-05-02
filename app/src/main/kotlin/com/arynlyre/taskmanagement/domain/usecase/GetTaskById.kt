package com.arynlyre.taskmanagement.domain.usecase

import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

fun interface GetTaskById {
    suspend operator fun invoke(taskId: Long): Flow<Task?>
}

suspend fun getTaskById(id: Long, taskRepository: TaskRepository): Flow<Task?> = taskRepository.getTask(id)
