package com.example.cinepro.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.cinepro.movieList.util.nvgraph.NavGraph
import com.example.cinepro.ui.theme.CineProTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

           setContent {
              CineProTheme {
//                val isSystemInDarkMode= isSystemInDarkTheme()
//                val systemController= rememberSystemUiController()

//                SideEffect{
//                    systemController.setSystemBarsColor(
//                        color= Color.Transparent,
//                        darkIcons = !isSystemInDarkMode
//                    )
//                }
                Box(modifier=Modifier.background(MaterialTheme.colorScheme.background)){
                    val startDestination=viewModel.startDestination
                    NavGraph(startDestination = startDestination)

                }

//                SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val navController= rememberNavController()
//
//                    NavHost(navController = navController,
//                        startDestination = Screen.Home.rout
//                    ){
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
                      // val movieListViewModel= hiltViewModel<MovieListViewModel>()
                }
            }
        }
    }
    @Composable
    private fun SetBarColor(color: Color){
        val systemUiController= rememberSystemUiController()
        LaunchedEffect(key1 = color ){
            systemUiController.setSystemBarsColor(color)
        }
    }

