package com.arynlyre.taskmanagement.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id: Long,
    val title: String,
    val desc: String,
    val isCompleted: Boolean
) : Parcelable
