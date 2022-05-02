package com.arynlyre.taskmanagement.data.source.local

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

@Serializable
data class Preferences(
    val darkModeEnabled: Boolean = false
)

object PreferencesSerializer : Serializer<Preferences> {
    override val defaultValue = Preferences()

    override suspend fun readFrom(input: InputStream): Preferences {
        try {
            return Json.decodeFromString(
                Preferences.serializer(), input.readBytes().decodeToString()
            )
        } catch (serialization: SerializationException) {
            throw CorruptionException("Unable to read Preferences", serialization)
        }
    }

    override suspend fun writeTo(t: Preferences, output: OutputStream) {
        output.write(Json.encodeToString(Preferences.serializer(), t).encodeToByteArray())
    }
}
