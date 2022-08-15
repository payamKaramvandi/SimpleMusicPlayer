package de.skoove.simplemusicplayer.presentation.ui.screens.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.skoove.core.domain.Data
import de.skoove.simplemusicplayer.framework.Interactors
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val interactors: Interactors
) : ViewModel() {


    var _selectedMusic = mutableStateOf(Data("", "", "", 0))
    val selectedMusic = _selectedMusic

    fun findMusicByName(musicName: String) {
        viewModelScope.launch {
            _selectedMusic.value = interactors.findMusicByName.invoke(musicName)
        }
    }




}