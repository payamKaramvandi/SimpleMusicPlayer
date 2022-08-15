package de.skoove.simplemusicplayer.framework

import de.skoove.core.usecases.FindMusicByName
import de.skoove.core.usecases.GetMusicList

data class Interactors(
    val getMusicList: GetMusicList,
    val findMusicByName: FindMusicByName
)