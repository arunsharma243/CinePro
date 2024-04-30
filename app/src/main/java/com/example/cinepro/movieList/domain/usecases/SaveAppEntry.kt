package com.example.cinepro.movieList.domain.usecases

import com.example.cinepro.movieList.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
    ) {
        suspend operator fun invoke(){
            localUserManager.saveAppEntry()
        }
}