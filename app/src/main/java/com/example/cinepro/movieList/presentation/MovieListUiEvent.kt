package com.example.cinepro.movieList.presentation

sealed interface MovieListUiEvent{
    data class Paginate(val category:String) : MovieListUiEvent
    object Navigate: MovieListUiEvent
}