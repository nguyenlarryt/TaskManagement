package com.arynlyre.taskmanagement.ui.list.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.arynlyre.taskmanagement.R
import com.arynlyre.taskmanagement.domain.model.TaskFilter
import com.arynlyre.taskmanagement.ui.theme.MVVMComposeTemplateTheme

@Composable
fun TaskListAppBar(onFilterSelected: (TaskFilter) -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        actions = {
            TaskFilterMenu(onFilterSelected)
        }
    )

}


@Preview
@Composable
fun TaskListAppbarPreview() {
    MVVMComposeTemplateTheme(darkTheme = false) {
        TaskListAppBar {}
    }
}
