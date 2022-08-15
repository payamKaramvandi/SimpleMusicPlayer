package de.skoove.simplemusicplayer.framework.network

import de.skoove.core.domain.MusicFeed
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {

    @GET("Learnfield-GmbH/CodingChallenge/master/react%20native/simple%20audio%20player/data/manifest.json")
    suspend fun getMusicList(): Response<MusicFeed>
}