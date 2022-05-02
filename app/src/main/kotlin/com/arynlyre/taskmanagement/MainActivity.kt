package com.arynlyre.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import cafe.adriel.voyager.navigator.Navigator
import com.arynlyre.taskmanagement.data.source.local.Preferences
import com.arynlyre.taskmanagement.ui.list.TaskListScreen
import com.arynlyre.taskmanagement.ui.theme.MVVMComposeTemplateTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkModeEnabled by remember { mutableStateOf(false) }
            val prefs = get<DataStore<Preferences>>()

            LaunchedEffect(Unit) {
                this.launch {
                    prefs.data.collect {
                        darkModeEnabled = it.darkModeEnabled
                    }
                }
            }

            MVVMComposeTemplateTheme(darkModeEnabled) {
                Navigator(TaskListScreen)
            }
        }
    }
}
