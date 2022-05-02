package com.arynlyre.taskmanagement.ui.list

import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.model.TaskFilter
import com.arynlyre.taskmanagement.domain.model.TaskFilter.ALL

data class TaskListState(
    val tasks: List<Task> = emptyList(),
    val currentFilter: TaskFilter = ALL
) {
    val filteredTasks: List<Task>
        get() = tasks.filter(currentFilter::filter)
}
