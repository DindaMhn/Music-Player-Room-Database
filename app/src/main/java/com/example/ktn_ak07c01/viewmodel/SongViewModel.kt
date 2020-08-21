package com.example.ktn_ak07c01.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ktn_ak07c01.room.AppRoomDatabase
import com.example.ktn_ak07c01.room.PlayList
import com.example.ktn_ak07c01.room.song.Song
import com.example.ktn_ak07c01.room.song.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SongRepository

    init {
        val songDao = AppRoomDatabase.getDatabaseInstance(application).songDao()
        repository = SongRepository(songDao)
    }

    fun getAllSong(id: Int) = repository.getAllSong(id)
    fun createNewSong(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createSong(song)
        }
    }
}