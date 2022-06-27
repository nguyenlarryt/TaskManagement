package com.arynlyre.taskmanagement.di

import org.koin.dsl.module
import org.koin.ksp.generated.module

val appModule = module {
    includes(UseCaseModule().module, DataModule().module)
}
