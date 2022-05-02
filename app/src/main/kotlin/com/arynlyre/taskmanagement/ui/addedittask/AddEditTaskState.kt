package com.arynlyre.taskmanagement.ui.addedittask

import com.arynlyre.taskmanagement.domain.model.Task

data class AddEditTaskState(
    val task: Task? = null,
    val title: String = "",
    val desc: String = ""
)
