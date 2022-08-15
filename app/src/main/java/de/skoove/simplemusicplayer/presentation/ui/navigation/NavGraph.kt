package de.skoove.simplemusicplayer.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import de.skoove.simplemusicplayer.presentation.ui.screens.detail.DetailScreen
import de.skoove.simplemusicplayer.presentation.ui.screens.home.HomeViewModel
import de.skoove.simplemusicplayer.presentation.ui.screens.home.MainScreen

@ExperimentalCoilApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
){
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){

        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(navArgument("MusicName"){type= NavType.StringType})
        ){ navBackStackEntry->
            val musicName=navBackStackEntry.arguments?.getString("MusicName")

            if (musicName != null) {
                DetailScreen(musicName=musicName )
            }
        }
    }

}