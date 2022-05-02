package com.arynlyre.taskmanagement.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arynlyre.taskmanagement.domain.usecase.DeleteTaskById
import com.arynlyre.taskmanagement.domain.usecase.GetTaskById
import com.arynlyre.taskmanagement.domain.usecase.UpdateTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.InjectedParam

@KoinViewModel
class TaskDetailsViewModel(
    @InjectedParam initialState: TaskDetailsState,
    private val getTaskById: GetTaskById,
    private val updateTask: UpdateTask,
    private val deleteTaskById: DeleteTaskById
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: MutableStateFlow<TaskDetailsState>
        get() = _state

    init {
        viewModelScope.launch {
            getTaskById(state.value.task.id).collect { taskResult ->
                if (taskResult != null) _state.update { it.copy(task = taskResult) }
            }
        }
    }

    fun process(event: TaskDetailsEvent) {
        when (event) {
            is CheckBoxToggled -> viewModelScope.launch { updateTask(state.value.task.copy(isCompleted = event.isComplete)) }
            DeleteTaskClicked -> viewModelScope.launch { deleteTaskById(state.value.task.id) }
        }
    }
}
