package com.arynlyre.taskmanagement

import android.app.Application
import com.arynlyre.taskmanagement.di.UseCaseModule
import com.arynlyre.taskmanagement.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule
import org.koin.ksp.generated.module

class TaskManagementApp : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@TaskManagementApp)
            modules(defaultModule, UseCaseModule().module, appModule)
        }
    }
}
