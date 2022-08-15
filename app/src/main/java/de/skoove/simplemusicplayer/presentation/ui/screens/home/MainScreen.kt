package de.skoove.simplemusicplayer.presentation.ui.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import de.skoove.core.domain.Data
import de.skoove.simplemusicplayer.presentation.ui.screens.common.ListContent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

@OptIn(ExperimentalCoilApi::class, ExperimentalCoroutinesApi::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    homeViewModel.getMusics()
    val allMusics = homeViewModel.allMusic

    Scaffold(

        content = {

            ListContent(
                navController = navController, items = allMusics.value
            )
        }
    )

}