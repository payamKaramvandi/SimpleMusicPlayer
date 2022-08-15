package de.skoove.core.usecases

import de.skoove.core.data.TestRepository
import kotlinx.coroutines.flow.first

class GetMusicList constructor(
    private val testRepository: TestRepository
) {
    operator fun invoke() = testRepository.getMusicList()
}