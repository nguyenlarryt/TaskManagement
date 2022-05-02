package com.arynlyre.taskmanagement.ui.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.arynlyre.taskmanagement.ui.addedittask.AddEditTaskScreen
import com.arynlyre.taskmanagement.ui.details.TaskDetailsScreen
import com.arynlyre.taskmanagement.ui.list.components.DrawerContent
import com.arynlyre.taskmanagement.ui.list.components.TaskListAppBar
import com.arynlyre.taskmanagement.ui.list.components.TaskListItem
import com.arynlyre.taskmanagement.ui.utils.observeAsState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

object TaskListScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<TaskListViewModel> { parametersOf(TaskListState()) }
        val state: TaskListState by viewModel.state.observeAsState()
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = {
                TaskListAppBar(
                    onFilterSelected = { viewModel.process(TaskFilterSelected(it)) },
                    onDrawerIconClicked = { scope.launch { scaffoldState.drawerState.open() } }
                )
            },
            drawerContent = { DrawerContent() },
            floatingActionButton = {
                FloatingActionButton(onClick = { navigator.push(AddEditTaskScreen()) }) {
                    Icon(Icons.Filled.Add, null, tint = Color.White)
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
