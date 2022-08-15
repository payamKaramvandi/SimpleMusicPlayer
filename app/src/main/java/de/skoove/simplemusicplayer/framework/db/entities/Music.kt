package de.skoove.simplemusicplayer.framework.db.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(
    tableName = "music",
    indices = [Index("title")]
)
data class Music(
    val audio: String,
    val cover: String,
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val totalDurationMs: Int
)
