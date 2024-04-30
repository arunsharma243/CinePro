package com.example.cinepro.movieList.util.nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.cinepro.core.presentation.HomeScreen
import com.example.cinepro.core.presentation.onBoarding.OnBoardingScreen
import com.example.cinepro.core.presentation.onBoarding.OnBoardingViewModel
import com.example.cinepro.details.presentation.DetailsScreen

@Composable
fun NavGraph(
    startDestination:String
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Screen.AppStartNavigation.rout,
            startDestination = Screen.OnBoardingScreen.rout
        ) {
            composable(
                route = Screen.OnBoardingScreen.rout
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation(
            route = Screen.NewsNavigation.rout,
            startDestination = Screen.Home.rout
        ) {
            composable(
                route = Screen.Home.rout
            ) {

                HomeScreen(navController)
            }
            composable(Screen.Details.rout + "/{movieId}",
                            arguments = listOf(
                                navArgument("movieId"){type = NavType.IntType}
                            )
                        ){
                           DetailsScreen()
                        }

        }
    }
}
// NavHost(
//navController = navController,
//startDestination = Screen.Home.rout
//) {
//                         composable(Screen.Home.rout){
//                             HomeScreen(navController)
//                         }
//
//                        composable(Screen.Details.rout + "/{movieId}",
//                            arguments = listOf(
//                                navArgument("movieId"){type = NavType.IntType}
//                            )
//                        ){
//                           DetailsScreen()
//                        }
//                    }
