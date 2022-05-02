package com.arynlyre.taskmanagement.ui.list.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.arynlyre.taskmanagement.R
import com.arynlyre.taskmanagement.domain.model.TaskFilter
import com.arynlyre.taskmanagement.ui.theme.MVVMComposeTemplateTheme

@Composable
fun TaskListAppBar(
    onDrawerIconClicked: () -> Unit,
    onFilterSelected: (TaskFilter) -> Unit
) {

    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = onDrawerIconClicked) {
                Icon(Icons.Filled.Menu, null)
            }
        },
        actions = {
            TaskFilterMenu(onFilterSelected)
        }
    )
}

@Preview
@Composable
fun TaskListAppbarPreview() {
    MVVMComposeTemplateTheme(darkTheme = false) {
        TaskListAppBar(onFilterSelected = {}, onDrawerIconClicked = {})
    }
}
