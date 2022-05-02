package com.arynlyre.taskmanagement.ui.list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arynlyre.taskmanagement.domain.model.TaskFilter
import com.arynlyre.taskmanagement.ui.theme.MVVMComposeTemplateTheme

@Composable
fun TaskFilterMenu(onFilterSelected: (TaskFilter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val filtersList = listOf(TaskFilter.ALL, TaskFilter.ACTIVE, TaskFilter.COMPLETE)
    var selectedFilter by remember { mutableStateOf(TaskFilter.ALL) }

    Box(modifier = Modifier.wrapContentSize()) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(Icons.Filled.FilterList, null)
        }

        DropdownMenu(
            modifier = Modifier.wrapContentSize(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            filtersList.forEach {
                DropdownMenuItem(
                    onClick = {
                        onFilterSelected(it)
                        selectedFilter = it
                        expanded = false
                    }
                ) {
                    Text(modifier = Modifier.weight(1f), text = it.name)

                    if (it != selectedFilter) Spacer(Modifier.size(24.dp))
                    else Icon(modifier = Modifier.size(24.dp), imageVector = Icons.Filled.Check, contentDescription = null)
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskFilterMenuPreview() {
    MVVMComposeTemplateTheme(darkTheme = false) {
        TopAppBar(
            title = { Text("TaskFilterMenu") },
            actions = {
                TaskFilterMenu { }
            }
        )
    }
}
