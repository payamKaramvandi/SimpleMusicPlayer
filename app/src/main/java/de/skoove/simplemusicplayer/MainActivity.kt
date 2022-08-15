package de.skoove.simplemusicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import dagger.hilt.android.AndroidEntryPoint
import de.skoove.simplemusicplayer.presentation.ui.navigation.SetupNavGraph
import de.skoove.simplemusicplayer.presentation.ui.screens.home.HomeViewModel
import de.skoove.simplemusicplayer.ui.theme.SimpleMusicPlayerTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel:HomeViewModel by viewModels()
    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleMusicPlayerTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }

}

