package com.arynlyre.taskmanagement.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.arynlyre.taskmanagement.Database
import com.arynlyre.taskmanagement.data.source.local.PreferencesSerializer
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single {
        DataStoreFactory.create(
            serializer = PreferencesSerializer,
            produceFile = { androidContext().dataStoreFile("PreferencesDataStore.pb") }
        )
    }
    factory { AndroidSqliteDriver(Database.Schema, androidContext(), "local.db") } bind SqlDriver::class
    single { Database(get()) }
}
