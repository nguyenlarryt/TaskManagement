package com.arynlyre.taskmanagement.domain.usecase

import app.cash.turbine.test
import com.arynlyre.taskmanagement.TaskRepositoryFake
import com.arynlyre.taskmanagement.domain.model.Task
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class GetTasksKtTest {
    @Test
    fun `getTasks should call TaskRepository`() = runTest {
        val taskRepository: TaskRepository = TaskRepositoryFake()
        val taskFake1 = Task(0, title = "fake task1", desc = "", isCompleted = false)
        val taskFake2 = Task(1, title = "fake task2", desc = "", isCompleted = false)

        taskRepository.updateTask(taskFake1)
        taskRepository.updateTask(taskFake2)

        getTasks(taskRepository).test {
            awaitItem() shouldContainExactlyInAnyOrder listOf(taskFake1, taskFake2)
            cancelAndConsumeRemainingEvents()
        }
    }
}
