package com.arynlyre.taskmanagement.ui.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.arynlyre.taskmanagement.domain.model.Task

@Composable
fun TaskListItem(
    task: Task,
    onCheckChanged: (Boolean) -> Unit,
    onTaskClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable { onTaskClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = { onCheckChanged(it) }
        )
        Text(
            modifier = Modifier.weight(1f)
                .padding(end = 16.dp),
            textDecoration = if (task.isCompleted) TextDecoration.LineThrough else null,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = task.title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TodoListItemPreview() {
    val taskFake = Task(
        id = 1,
        title = LoremIpsum(20).values.joinToString(),
        desc = "desc1",
        isCompleted = false
    )

    Box(Modifier.fillMaxSize()) {
        TaskListItem(taskFake, {}, {})
    }
}
