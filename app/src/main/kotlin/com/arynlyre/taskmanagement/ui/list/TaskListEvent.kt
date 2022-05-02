package com.arynlyre.taskmanagement.ui.list

import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.model.TaskFilter

sealed interface TaskListEvent

object AddTaskClicked : TaskListEvent
data class CheckBoxToggled(val task: Task, val isComplete: Boolean) : TaskListEvent
data class TaskFilterSelected(val filter: TaskFilter): TaskListEvent
