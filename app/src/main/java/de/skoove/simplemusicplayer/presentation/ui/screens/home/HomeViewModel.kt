package de.skoove.simplemusicplayer.presentation.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.skoove.core.domain.Data
import de.skoove.core.domain.MusicFeed
import de.skoove.core.domain.Resource
import de.skoove.simplemusicplayer.framework.Interactors
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val interactors: Interactors
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    private var _allMusics = mutableStateOf(emptyList<Data>())
    val allMusic= _allMusics
    fun getMusics(){
        viewModelScope.launch {
            _allMusics.value= interactors.getMusicList.invoke().first().data!!
        }
    }

}