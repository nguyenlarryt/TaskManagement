package com.arynlyre.taskmanagement.di

import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import com.arynlyre.taskmanagement.domain.usecase.AddTask
import com.arynlyre.taskmanagement.domain.usecase.DeleteTaskById
import com.arynlyre.taskmanagement.domain.usecase.GetTaskById
import com.arynlyre.taskmanagement.domain.usecase.GetTasks
import com.arynlyre.taskmanagement.domain.usecase.UpdateTask
import com.arynlyre.taskmanagement.domain.usecase.addTask
import com.arynlyre.taskmanagement.domain.usecase.deleteTaskById
import com.arynlyre.taskmanagement.domain.usecase.getTaskById
import com.arynlyre.taskmanagement.domain.usecase.getTasks
import com.arynlyre.taskmanagement.domain.usecase.updateTask
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class UseCaseModule {
    @Factory
    fun provideGetTasks(taskRepository: TaskRepository) = GetTasks { getTasks(taskRepository) }

    @Factory
    fun provideAddTask(taskRepository: TaskRepository) = AddTask { title, desc -> addTask(title, desc, taskRepository) }

    @Factory
    fun provideUpdateTask(taskRepository: TaskRepository) = UpdateTask { task -> updateTask(task, taskRepository) }

    @Factory
    fun provideGetTaskById(taskRepository: TaskRepository) = GetTaskById { taskId -> getTaskById(taskId, taskRepository) }

    @Factory
    fun provideDeleteTaskById(taskRepository: TaskRepository) = DeleteTaskById { taskId -> deleteTaskById(taskId, taskRepository) }
}
