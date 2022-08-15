package de.skoove.simplemusicplayer.presentation.components

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import de.skoove.simplemusicplayer.presentation.ui.screens.detail.MediaPlayerViewModel

@Composable
fun PlayerSlider(mediaPlayer: MediaPlayer) {
    val viewModel: MediaPlayerViewModel = viewModel()
    val currentMinutes = viewModel.currentMinutes.collectAsState()

    Column(modifier = Modifier.fillMaxWidth()) {
        Slider(
            value = currentMinutes.value.toFloat(),
            onValueChange = {},
            valueRange = 0f..mediaPlayer.duration.toFloat(),
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTickColor = Color.White
            )
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "${currentMinutes.value/60000}:${currentMinutes.value/1000%60}", color = Color.White)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "${mediaPlayer.duration/60000}:${mediaPlayer.duration/1000%60}", color = Color.White)

        }
    }
}