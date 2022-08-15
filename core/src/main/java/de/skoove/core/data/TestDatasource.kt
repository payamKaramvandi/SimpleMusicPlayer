package de.skoove.core.data

import de.skoove.core.domain.Data
import de.skoove.core.domain.Resource
import kotlinx.coroutines.flow.Flow

interface TestDatasource {

    fun getMusicList(): Flow<Resource<List<Data>>>

    suspend fun findMusicByName(
        musicName: String
    ): Data
}