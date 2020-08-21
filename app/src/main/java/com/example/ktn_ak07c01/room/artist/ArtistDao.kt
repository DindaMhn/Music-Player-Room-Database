package com.example.ktn_ak07c01.room.artist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ArtistDao {
    @Transaction
    @Insert
    fun createArtist(artis: Artist)

    @Query(value = "SELECT * FROM Artist")
    fun getAllArtist(): LiveData<List<Artist>>

    @Query(value = "SELECT * FROM Artist WHERE artist_id= :artist_id")
    fun getArtistById(artist_id: Int): Artist
}