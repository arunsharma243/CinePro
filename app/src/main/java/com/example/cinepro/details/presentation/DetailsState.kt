package com.example.cinepro.details.presentation

import com.example.cinepro.movieList.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean=false,
    val movie: Movie? =null
)
