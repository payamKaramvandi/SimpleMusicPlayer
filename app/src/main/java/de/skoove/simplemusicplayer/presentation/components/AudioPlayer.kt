package de.skoove.simplemusicplayer.presentation.components

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import de.skoove.simplemusicplayer.R
import de.skoove.simplemusicplayer.presentation.ui.screens.detail.DetailViewModel

@Composable
fun AudioPlayer(mediaPlayer: MediaPlayer) {
    val viewModel:DetailViewModel  = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Blue,
                        Color.LightGray
                    )
                )
            )
            .padding(horizontal = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = "Image Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .sizeIn(maxHeight = 500.dp, maxWidth = 500.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .weight(10f)
            )

            Spacer(modifier = Modifier.height(30.dp))
            SongDescription("Audio Name", "Singer Name")
            Spacer(modifier = Modifier.height(35.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(10f)
            ) {
                PlayerSlider(mediaPlayer)
                Spacer(modifier = Modifier.height(40.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}