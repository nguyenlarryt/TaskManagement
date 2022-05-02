package com.arynlyre.taskmanagement.data.source.local

import com.arynlyre.taskmanagement.Database
import com.arynlyre.taskmanagement.data.mapper.TaskMapper
import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

@Single
class TaskRepositoryImpl(
    private val database: Database,
    private val mapper: TaskMapper
) : TaskRepository {
    override suspend fun getTasks(): Flow<List<Task>> =
        database.taskQueries.selectAll(::Task).asFlow().mapToList()

    override suspend fun getTask(id: Long): Flow<Task?> =
        database.taskQueries.selectById(id).asFlow()
            .mapToOneOrNull()
            .map { taskDto ->
                if (taskDto == null) null else mapper.mapToDomainModel(taskDto)
            }

    override suspend fun addTask(title: String, desc: String, isCompleted: Boolean) {
        database.taskQueries.addNewTask(title, desc, isCompleted)
    }

    override suspend fun updateTask(task: Task) {
        database.taskQueries.updateTask(
            id = task.id,
            title = task.title,
            desc = task.desc,
            isCompleted = task.isCompleted
        )
    }

    override suspend fun deleteTask(taskId: Long) {
        database.taskQueries.delete(taskId)
    }

    override suspend fun deleteAllTasks() {
        database.taskQueries.deleteAll()
    }
}
