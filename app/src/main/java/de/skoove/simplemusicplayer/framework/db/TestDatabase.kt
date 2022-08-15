package de.skoove.simplemusicplayer.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import de.skoove.simplemusicplayer.framework.db.entities.Music
import de.skoove.simplemusicplayer.framework.db.dao.TestDao

@Database(
    entities = [Music::class], version = 1, exportSchema = false
)

abstract class TestDatabase : RoomDatabase() {
    abstract fun testDao(): TestDao
}