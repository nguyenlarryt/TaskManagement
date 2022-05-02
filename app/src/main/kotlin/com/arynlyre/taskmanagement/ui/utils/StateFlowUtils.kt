package com.arynlyre.taskmanagement.ui.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun <T> StateFlow<T>.observeAsState(): State<T> = this.asLiveData().observeAsState(this.value)
