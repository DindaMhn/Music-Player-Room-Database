package com.example.ktn_ak07c01.room

import androidx.room.Embedded
import androidx.room.Relation
import com.example.ktn_ak07c01.room.artist.Artist
import com.example.ktn_ak07c01.room.song.Song

class PlayList(
    @Embedded val artist: Artist,
    @Relation(
        parentColumn = "artist_id",
        entityColumn = "id_artist"
    )
    val playLists:List<Song>
)