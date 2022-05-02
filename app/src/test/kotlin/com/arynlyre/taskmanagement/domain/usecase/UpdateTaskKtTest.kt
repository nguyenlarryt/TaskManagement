package com.arynlyre.taskmanagement.domain.usecase

import com.arynlyre.taskmanagement.TaskRepositoryFake
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class UpdateTaskKtTest {
    @Test
    fun `updateTask should call TaskRepository`() = runTest {
        val taskRepository: TaskRepository = TaskRepositoryFake()

        taskRepository.addTask("test title", "test desc", false)

        val originalTask = taskRepository.getTasks().first().first()
        val updatedTask = originalTask.copy(title = "new title", desc = "new desc")

        updateTask(updatedTask, taskRepository)
        taskRepository.getTask(originalTask.id).first() shouldBe updatedTask
    }
}
