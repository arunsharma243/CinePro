package com.example.cinepro.movieList.util.nvgraph

sealed class Screen(val rout: String){
    object OnBoardingScreen: Screen( "onBoardingScreen")
    object AppStartNavigation: Screen( "appStartNavigation")
    object NewsNavigatorScreen: Screen("newsNavigator")

    object NewsNavigation: Screen("newsNavigation")
    object Home: Screen("main")
    object PopularMovieList: Screen("popularMovie")
    object UpcomingMovieList: Screen("upcomingMovie")
    object Details: Screen("details")

}
