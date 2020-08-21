package com.example.ktn_ak07c01.room.song

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.ktn_ak07c01.room.PlayList

@Dao
interface SongDao {
    @Insert
    fun createSong(song: Song)

    @Transaction
    @Query(value = "SELECT * FROM Artist WHERE artist_id= :id_artist")
    fun getAllSong(id_artist: Int): LiveData<PlayList>

    @Query(value = "SELECT * FROM Song WHERE id= :id")
    fun getSongById(id: Int): Song
}