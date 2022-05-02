package com.arynlyre.taskmanagement.domain.usecase

import app.cash.turbine.test
import com.arynlyre.taskmanagement.TaskRepositoryFake
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class GetTaskByIdKtTest {
    @Test
    fun `getTaskById should get task from TaskRepository`() = runTest {
        val taskRepository: TaskRepository = TaskRepositoryFake()

        taskRepository.addTask("getTaskById Title", "desc", false)

        taskRepository.getTasks().test {
            val firstTask = awaitItem().first()

            getTaskById(firstTask.id, taskRepository).first() shouldBe firstTask
            cancelAndConsumeRemainingEvents()
        }
    }
}
