package de.skoove.simplemusicplayer.framework.repository

import com.bumptech.glide.load.HttpException
import de.skoove.core.data.TestDatasource
import de.skoove.core.domain.Data
import de.skoove.core.domain.Resource
import de.skoove.simplemusicplayer.framework.db.TestDatabase
import de.skoove.simplemusicplayer.framework.db.entities.Music
import de.skoove.simplemusicplayer.framework.network.TestApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(
    private val testApi: TestApi,
    private val testDatabase: TestDatabase
) : TestDatasource {


    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getMusicList(): Flow<Resource<List<Data>>> =
        networkBoundResource(
            query = {
                    testDatabase.testDao().getAllMusics()
            },
            fetch = {
                testApi.getMusicList()
            },
            saveFetchResult = {
                it.data.forEach { music->
                    testDatabase.testDao().insertMusic(
                        Music(
                            audio = music.audio,
                            cover = music.cover,
                            title = music.title,
                            totalDurationMs = music.totalDurationMs

                            )
                    )
                }
            }

        )

    override suspend fun findMusicByName(musicName: String): Data {
        return testDatabase.testDao().getMusicByName(musicName)
    }

}