package de.skoove.simplemusicplayer.presentation.ui.screens.detail

import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import de.skoove.simplemusicplayer.R
import de.skoove.simplemusicplayer.presentation.components.AudioPlayer
import java.net.URI

@Composable
fun DetailScreen(
    musicName: String,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.findMusicByName(musicName)


    val musicTrack = remember(musicName) {
        viewModel.selectedMusic
    }
    val mediaPlayer: MediaPlayer = MediaPlayer.create(
        LocalContext.current, Uri.parse(musicTrack.value.audio))
    AudioPlayer(mediaPlayer =mediaPlayer )
}

