package de.skoove.core.usecases

import de.skoove.core.data.TestRepository


class FindMusicByName constructor(
    private val testRepository: TestRepository
) {
    suspend operator fun invoke(musicName:String) = testRepository.findMusicByName(musicName)
}