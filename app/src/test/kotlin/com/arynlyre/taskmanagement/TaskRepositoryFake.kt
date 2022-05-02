package com.arynlyre.taskmanagement

import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TaskRepositoryFake : TaskRepository {
    private val dbFake = mutableMapOf<Long, Task>()

    companion object {
        fun getFakeTasks(): List<Task> = listOf(
            Task(
                1,
                title = "title1",
                desc = "desc1",
                isCompleted = false
            ),
            Task(
                2,
                title = "title2",
                desc = "desc2",
                isCompleted = false
            ),
            Task(
                3,
                title = "title3",
                desc = "desc3",
                isCompleted = false
            )
        )
    }

    override suspend fun getTasks(): Flow<List<Task>> = flowOf(dbFake.values.toList())

    override suspend fun getTask(id: Long): Flow<Task> = flowOf(dbFake[id]!!)
    override suspend fun addTask(title: String, desc: String, isCompleted: Boolean) {
        val taskId = dbFake.size.toLong()
        dbFake[taskId] = Task(taskId, title, desc, isCompleted)
    }

    override suspend fun updateTask(task: Task) {
        dbFake[task.id] = task
    }

    override suspend fun deleteTask(taskId: Long) {
        dbFake.remove(taskId)
    }

    override suspend fun deleteAllTasks() {
        dbFake.clear()
    }
}
