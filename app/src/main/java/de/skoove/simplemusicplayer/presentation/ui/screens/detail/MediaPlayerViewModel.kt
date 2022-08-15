package de.skoove.simplemusicplayer.presentation.ui.screens.detail

import android.media.MediaPlayer
import android.os.CountDownTimer
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

class MediaPlayerViewModel: ViewModel() {

    private var currentDuration: CountDownTimer? = null

    val currentMinutes = MutableStateFlow(0)

    val audioFinish = MutableStateFlow(false)

    fun getMediaDuration(mediaPlayer: MediaPlayer) {
        currentDuration = object : CountDownTimer(mediaPlayer.duration.toLong(), 500) {

            override fun onTick(milliSec: Long) {
                currentMinutes.value = mediaPlayer.currentPosition
            }

            override fun onFinish() {
                audioFinish.value = true
                Log.d("Media", "onFinish: Media Player Finished")
            }


        }
        currentDuration?.start()
    }

    fun getFirstColor(): Color {
        val random = Random()
        val color: Int = android.graphics.Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )

        return  Color(color)
    }

    fun getSecondColor(): Color {
        val random = Random()
        val color: Int = android.graphics.Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )

        return  Color(color)
    }
}