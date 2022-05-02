package com.arynlyre.taskmanagement.ui.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.arynlyre.taskmanagement.domain.model.Task

@Composable
fun TaskDetailsContent(task: Task, onCheckChanged: (Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(Modifier.padding(top = 8.dp, end = 16.dp)) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { onCheckChanged(it) }
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (task.isCompleted) TextDecoration.LineThrough else null
                )
                Text(
                    task.desc,
                    textDecoration = if (task.isCompleted) TextDecoration.LineThrough else null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskDetailsContentPreview() {
    val taskFake = Task(
        id = 1,
        title = LoremIpsum(10).values.joinToString(),
        desc = LoremIpsum(500).values.joinToString(),
        isCompleted = false
    )

    Box(Modifier.fillMaxSize()) {
        TaskDetailsContent(taskFake) { }
    }
}
