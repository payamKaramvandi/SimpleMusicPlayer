package de.skoove.simplemusicplayer.presentation.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mahmoudalim.compose_rating_bar.RatingBarView
import de.skoove.core.domain.Data
import de.skoove.simplemusicplayer.R
import de.skoove.simplemusicplayer.presentation.ui.screens.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoilApi
@Composable
fun ListContent(navController: NavHostController, items: List<Data>) {
    val homeViewModel: HomeViewModel = hiltViewModel()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            key = { musicTrack ->
                musicTrack.title
            }
        ) { musicTrack ->
            MusicItem(navController, musicTrack = musicTrack)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MusicItem(navController: NavHostController, musicTrack: Data) {

    val painter = rememberImagePainter(data = musicTrack.cover) {
        crossfade(durationMillis = 1000)
        error(R.drawable.ic_placeholder)
        placeholder(R.drawable.ic_placeholder)
    }

    Column(
        modifier = Modifier
            .clickable {
                navController.navigate("detail_screen/${musicTrack.title}") {
                    launchSingleTop = true
                }
            }
            .height(300.dp)
            .fillMaxWidth(),

    ) {
        Row(
            modifier= Modifier
                        .fillMaxWidth(),
        ) {
            Box() {

                Image(
                    modifier=Modifier.fillMaxWidth(),
                    painter = painter,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Track_Title"
                )
                RatingBarView(
                    rating = remember { mutableStateOf(0) },
                    isRatingEditable = false,
                    ratedStarsColor = Color(255, 220, 0),
                    starIcon = painterResource(id = R.drawable.star_line_black),
                    starSize = 25.dp,
                    unRatedStarsColor = Color.LightGray
                )
            }
        }
        Row() {
            Text(text = musicTrack.title)
        }


    }


}


@ExperimentalCoilApi
@Composable
@Preview
fun PixabayImagePreview() {
    MusicItem(
        navController = rememberNavController(),
        musicTrack = Data(
            "",
            "",
            "payam",
            1234
        )
    )
}
