package com.arynlyre.taskmanagement.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.ui.utils.observeAsState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

data class TaskDetailsScreen(val task: Task) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<TaskDetailsViewModel> { parametersOf(TaskDetailsState(task)) }
        val state: TaskDetailsState by viewModel.state.observeAsState()

        Scaffold(
            topBar = { TopAppBar(title = { Text("Task Details") }) }
        ) {
            Row(Modifier.fillMaxSize()) {
                Checkbox(
                    checked = state.task.isCompleted,
                    onCheckedChange = { viewModel.process(CheckBoxToggled(it)) }
                )

                Column {
                    Text(state.task.title)
                    Text(state.task.desc)
                }
            }
        }
    }
}
