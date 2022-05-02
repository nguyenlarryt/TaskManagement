package com.arynlyre.taskmanagement.ui.addedittask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arynlyre.taskmanagement.domain.usecase.AddTask
import com.arynlyre.taskmanagement.domain.usecase.UpdateTask
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.InjectedParam

@KoinViewModel
class AddEditTaskViewModel(
    @InjectedParam initialState: AddEditTaskState,
    private val addTask: AddTask,
    private val updateTask: UpdateTask
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<AddEditTaskState>
        get() = _state

    fun process(event: AddEditTaskEvent) {
        when (event) {
            AddTaskClicked -> viewModelScope.launch {
                _state.value.let {
                    addTask(it.title, it.desc)
                }
            }
            SaveTaskClicked -> viewModelScope.launch {
                _state.value.let {
                    if (it.task != null) updateTask(it.task.copy(title = it.title, desc = it.desc))
                }
            }
            is DescriptionChanged -> _state.update { it.copy(desc = event.text) }
            is TitleChanged -> _state.update { it.copy(title = event.text) }
        }
    }
}
