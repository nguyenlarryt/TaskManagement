package com.arynlyre.taskmanagement.ui.list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.datastore.core.DataStore
import com.arynlyre.taskmanagement.data.source.local.Preferences
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@Composable
fun DrawerContent() {
    val prefs = get<DataStore<Preferences>>()
    val scope = rememberCoroutineScope()
    var isDarkMode by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        this.launch {
            prefs.data.collect {
                isDarkMode = it.darkModeEnabled
            }
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = isDarkMode,
            onCheckedChange = { checked ->
                scope.launch {
                    prefs.updateData {
                        it.copy(darkModeEnabled = checked)
                    }
                }
            }
        )
        Text("Dark Mode")
    }
}
