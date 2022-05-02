package com.arynlyre.taskmanagement.domain.usecase

import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

fun interface GetTasks {
    suspend operator fun invoke(): Flow<List<Task>>
}

suspend fun getTasks(taskRepository: TaskRepository): Flow<List<Task>> = taskRepository.getTasks()
