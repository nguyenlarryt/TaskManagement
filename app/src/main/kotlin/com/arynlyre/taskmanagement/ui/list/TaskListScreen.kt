package com.arynlyre.taskmanagement.ui.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arynlyre.taskmanagement.ui.addedittask.AddEditTaskScreen
import com.arynlyre.taskmanagement.ui.details.TaskDetailsScreen
import com.arynlyre.taskmanagement.ui.list.components.TaskListAppBar
import com.arynlyre.taskmanagement.ui.list.components.TaskListItem
import com.arynlyre.taskmanagement.ui.utils.observeAsState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

object TaskListScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<TaskListViewModel> { parametersOf(TaskListState()) }
        val state: TaskListState by viewModel.state.observeAsState()

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TaskListAppBar(onFilterSelected = { viewModel.process(TaskFilterSelected(it)) }) },
            floatingActionButton = {
                FloatingActionButton(onClick = { navigator.push(AddEditTaskScreen()) }) {
                    Icon(Icons.Filled.Add, null)
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(state.filteredTasks) { _, task ->
                    TaskListItem(
                        task,
                        onCheckChanged = { isChecked -> viewModel.process(CheckBoxToggled(task, isChecked)) },
                        onTaskClicked = { navigator.push(TaskDetailsScreen(task)) }
                    )
                }
            }
        }
    }
}
