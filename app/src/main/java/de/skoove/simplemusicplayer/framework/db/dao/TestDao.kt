package de.skoove.simplemusicplayer.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.skoove.simplemusicplayer.framework.db.entities.Music
import de.skoove.core.domain.Data
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Query("SELECT * FROM music")
    fun getAllMusics(): Flow<List<Data>>

    @Query("SELECT * FROM music WHERE title= :name")
    suspend fun getMusicByName(name: String): Data

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMusic(images: Music)

    @Query("DELETE FROM music")
    suspend fun deleteAllMusics()

}