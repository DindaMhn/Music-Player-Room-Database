package com.example.ktn_ak07c01.room.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Artist(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var artist_id: Int=0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "image") var image: String
) {

}