package com.example.ktn_ak07c01.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ktn_ak07c01.room.AppRoomDatabase
import com.example.ktn_ak07c01.room.artist.Artist
import com.example.ktn_ak07c01.room.artist.ArtistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistViewModel (application: Application):AndroidViewModel(application) {
    private val repository : ArtistRepository
    val allArtist : LiveData<List<Artist>>
    init{
        val artistDao = AppRoomDatabase.getDatabaseInstance(application).artistDao()
        repository = ArtistRepository(artistDao)
        allArtist = repository.allArtist
    }
    fun createNewArtist(artist: Artist) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createArtist(artist)
        }
    }
}