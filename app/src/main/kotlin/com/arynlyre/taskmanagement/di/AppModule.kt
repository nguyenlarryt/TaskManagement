package com.arynlyre.taskmanagement.di

import com.arynlyre.taskmanagement.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    factory { AndroidSqliteDriver(Database.Schema, androidContext(), "local.db") } bind SqlDriver::class
    single { Database(get()) }
}
