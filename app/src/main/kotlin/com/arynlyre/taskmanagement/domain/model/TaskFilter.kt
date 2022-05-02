package com.arynlyre.taskmanagement.domain.model

enum class TaskFilter {
    ALL, ACTIVE, COMPLETE;

    fun filter(task: Task): Boolean = when (this) {
        ALL -> true
        ACTIVE -> task.isCompleted.not()
        COMPLETE -> task.isCompleted
    }
}
