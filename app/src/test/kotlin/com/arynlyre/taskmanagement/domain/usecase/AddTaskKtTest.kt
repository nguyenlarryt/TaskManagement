package com.arynlyre.taskmanagement.domain.usecase

import app.cash.turbine.test
import com.arynlyre.taskmanagement.TaskRepositoryFake
import com.arynlyre.taskmanagement.domain.repository.TaskRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class AddTaskKtTest {
    @Test
    fun `addTask should call TaskRepository`() = runTest {
        val taskRepository: TaskRepository = TaskRepositoryFake()

        val title = "add task title"
        val desc = "add task desc"

        addTask(title, desc, taskRepository)

        taskRepository.getTasks().test {
            val task = awaitItem().first()

            task.title shouldBe title
            task.desc shouldBe desc
            task.isCompleted shouldBe false

            cancelAndConsumeRemainingEvents()
        }
    }
}
