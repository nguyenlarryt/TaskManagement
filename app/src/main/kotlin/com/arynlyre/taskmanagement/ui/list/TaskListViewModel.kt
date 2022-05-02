package com.arynlyre.taskmanagement.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arynlyre.taskmanagement.domain.usecase.GetTasks
import com.arynlyre.taskmanagement.domain.usecase.UpdateTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.InjectedParam

@KoinViewModel
class TaskListViewModel(
    @InjectedParam initialState: TaskListState,
    private val getTasks: GetTasks,
    private val updateTask: UpdateTask
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<TaskListState>
        get() = _state

    init {
        viewModelScope.launch {
            getTasks().collect { tasksResult ->
                _state.update { it.copy(tasks = tasksResult) }
            }
        }
    }

    fun process(event: TaskListEvent) {
        when (event) {
            AddTaskClicked -> {}
            is CheckBoxToggled -> viewModelScope.launch {
                updateTask(event.task.copy(isCompleted = event.isComplete))
            }
            is TaskFilterSelected -> _state.update { it.copy(currentFilter = event.filter) }
        }
    }
}
