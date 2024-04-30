package com.example.cinepro.core.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinepro.movieList.domain.usecases.AppEntryUseCases
import com.example.cinepro.movieList.util.nvgraph.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Screen.AppStartNavigation.rout)
        private set

    init{
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                startDestination= Screen.NewsNavigation.rout
            }else{
                startDestination= Screen.AppStartNavigation.rout
            }
            delay(300)
            splashCondition=false
        }.launchIn(viewModelScope)
    }


}