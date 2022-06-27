package com.arynlyre.taskmanagement.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.arynlyre.taskmanagement.Database
import com.arynlyre.taskmanagement.data.source.local.Preferences
import com.arynlyre.taskmanagement.data.source.local.PreferencesSerializer
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class DataModule {
    @Single
    fun provideDataStore(context: Context): DataStore<Preferences> = DataStoreFactory.create(
        serializer = PreferencesSerializer,
        produceFile = { context.dataStoreFile("PreferencesDataStore.pb") }
    )

    @Factory
    fun provideAndroidSqliteDriver(context: Context): SqlDriver = AndroidSqliteDriver(Database.Schema, context, "local.db")

    @Single
    fun provideDatabase(sqlDriver: SqlDriver): Database = Database(sqlDriver)
}
