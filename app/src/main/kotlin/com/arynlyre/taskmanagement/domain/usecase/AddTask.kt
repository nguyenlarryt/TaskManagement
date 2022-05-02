package com.arynlyre.taskmanagement.domain.usecase

import com.arynlyre.taskmanagement.domain.repository.TaskRepository

fun interface AddTask {
    suspend operator fun invoke(title: String, desc: String)
}

suspend fun addTask(
    title: String,
    desc: String,
    taskRepository: TaskRepository
) {
    taskRepository.addTask(title, desc, false)
}
