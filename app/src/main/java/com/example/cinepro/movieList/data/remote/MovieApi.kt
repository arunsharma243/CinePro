package com.example.cinepro.movieList.data.remote

import com.example.cinepro.movieList.data.remote.respond.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/{category}")
    suspend fun getMoviesList(
          @Path("category") category: String,
          @Query("page") page:Int,
          @Query("api_key") apikey: String= API_KEY
    ): MovieListDto
    companion object{
        const val BASE_URL="https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL="https://image.tmdb.org/t/p/w500"
        const val API_KEY="dc3e1a0b573c11ca04f5cc371062d4b0"

    }
}