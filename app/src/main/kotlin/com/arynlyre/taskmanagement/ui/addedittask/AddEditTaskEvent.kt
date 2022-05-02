package com.arynlyre.taskmanagement.ui.addedittask

sealed interface AddEditTaskEvent

object AddTaskClicked : AddEditTaskEvent
object SaveTaskClicked : AddEditTaskEvent
data class TitleChanged(val text: String) : AddEditTaskEvent
data class DescriptionChanged(val text: String) : AddEditTaskEvent
