package com.arynlyre.taskmanagement.domain.usecase

import app.cash.turbine.test
import com.arynlyre.taskmanagement.TaskRepositoryFake
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class DeleteTaskByIdKtTest {
    @Test
    fun `deleteTaskById should call TaskRepository`() = runTest {
        val taskRepository: TaskRepository = TaskRepositoryFake()

        taskRepository.addTask(title = "title", desc = "desc", isCompleted = false)
        taskRepository.getTasks().test {
            awaitItem().size shouldBe 1
            cancelAndConsumeRemainingEvents()
        }

        deleteTaskById(0, taskRepository)

        taskRepository.getTasks().test {
            awaitItem().size shouldBe 0
            cancelAndConsumeRemainingEvents()
        }
    }
}
