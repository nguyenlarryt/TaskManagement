package com.arynlyre.taskmanagement.ui.details

sealed interface TaskDetailsEvent

object DeleteTaskClicked : TaskDetailsEvent
data class CheckBoxToggled(val isComplete: Boolean) : TaskDetailsEvent
