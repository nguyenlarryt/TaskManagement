package com.arynlyre.taskmanagement.ui.details

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arynlyre.taskmanagement.R
import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.ui.addedittask.AddEditTaskScreen
import com.arynlyre.taskmanagement.ui.details.components.TaskDetailsContent
import com.arynlyre.taskmanagement.ui.utils.observeAsState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

data class TaskDetailsScreen(val task: Task) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<TaskDetailsViewModel> { parametersOf(TaskDetailsState(task)) }
        val state: TaskDetailsState by viewModel.state.observeAsState()

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.task_details_title)) },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                viewModel.process(DeleteTaskClicked)
                                navigator.pop()
                            }
                        ) {
                            Icon(Icons.Filled.Delete, null)
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { navigator.push(AddEditTaskScreen(task)) }) {
                    Icon(Icons.Filled.Edit, null, tint = Color.White)
                }
            }
        ) {
            TaskDetailsContent(state.task) { viewModel.process(CheckBoxToggled(it)) }
        }
    }
}
