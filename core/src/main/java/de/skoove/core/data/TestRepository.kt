package de.skoove.core.data

class TestRepository(
    private val testDatasource: TestDatasource
) {
    fun getMusicList() = testDatasource.getMusicList()
    suspend fun findMusicByName(
        musicName: String
    ) = testDatasource.findMusicByName(musicName)
}