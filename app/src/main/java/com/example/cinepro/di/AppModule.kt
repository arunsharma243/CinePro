package com.example.cinepro.di

import android.app.Application
import androidx.room.Room
import com.example.cinepro.movieList.data.local.movie.MovieDatabase
import com.example.cinepro.movieList.data.manager.LocalUserManagerImpl
import com.example.cinepro.movieList.data.remote.MovieApi
import com.example.cinepro.movieList.domain.manager.LocalUserManager
import com.example.cinepro.movieList.domain.usecases.AppEntryUseCases
import com.example.cinepro.movieList.domain.usecases.ReadAppEntry
import com.example.cinepro.movieList.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val interceptor: HttpLoggingInterceptor= HttpLoggingInterceptor().apply{
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient= OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun providesMovieApi(): MovieApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MovieApi.BASE_URL)
            .client(client)
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(app:Application):MovieDatabase{
       return Room.databaseBuilder(
        app,
        MovieDatabase::class.java,
        "moviedb.db"
       ).build()
    }
}