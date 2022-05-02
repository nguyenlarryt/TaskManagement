package com.arynlyre.taskmanagement.ui.addedittask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        val viewModel = getViewModel<AddEditTaskViewModel> {
            parametersOf(
                AddEditTaskState(
                    task,
                    title = task?.title ?: "",
                    desc = task?.desc ?: ""
                )
            )
        }
        val state: AddEditTaskState by viewModel.state.observeAsState()

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(if (task == null) "Add Task" else "Edit Task") },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        viewModel.process(if (task == null) AddTaskClicked else SaveTaskClicked)
                        navigator.pop()
                    }
                ) {
                    Icon(if (task == null) Icons.Filled.Add else Icons.Filled.Check, null, tint = Color.White)
                }
            }
        ) {
            Column(Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 8.dp)) {
                OutlinedTextField(
                    value = state.title,
                    onValueChange = { viewModel.process(TitleChanged(it)) },
                    label = { Text("Title") }
                )
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = state.desc,
                    onValueChange = { viewModel.process(DescriptionChanged(it)) },
                    label = { Text("Description") }
                )
            }
        }
    }
}
