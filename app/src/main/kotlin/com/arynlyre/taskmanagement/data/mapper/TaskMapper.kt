package com.arynlyre.taskmanagement.data.mapper

import com.arynlyre.taskmanagement.domain.model.Task
import org.koin.core.annotation.Factory
import db.Task as TaskDto

@Factory
class TaskMapper : DomainMapper<TaskDto, Task>() {
    override fun mapToDomainModel(dto: TaskDto): Task =
        Task(id = dto.id, title = dto.title, desc = dto.desc, isCompleted = dto.isCompleted)

    override fun mapToDto(model: Task): TaskDto =
        TaskDto(id = model.id, title = model.title, desc = model.desc, isCompleted = model.isCompleted)
}
