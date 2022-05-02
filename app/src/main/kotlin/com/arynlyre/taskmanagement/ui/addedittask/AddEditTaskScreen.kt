package com.arynlyre.taskmanagement.ui.addedittask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.ui.utils.observeAsState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

data class AddEditTaskScreen(val task: Task? = null) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<AddEditTaskViewModel> { parametersOf(AddEditTaskState(task)) }
        val state: AddEditTaskState by viewModel.state.observeAsState()

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = { TopAppBar { Text(if (task == null) "Add Task" else "Edit Task") } },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        viewModel.process(if (task == null) AddTaskClicked else SaveTaskClicked)
                        navigator.pop()
                    }
                ) {
                    Icon(if (task == null) Icons.Filled.Add else Icons.Filled.Check, null)
                }
            }
        ) {
            Column(Modifier.fillMaxSize()) {
                OutlinedTextField(value = state.title, onValueChange = { viewModel.process(TitleChanged(it)) })
                OutlinedTextField(value = state.desc, onValueChange = { viewModel.process(DescriptionChanged(it)) })
            }
        }
    }
}
