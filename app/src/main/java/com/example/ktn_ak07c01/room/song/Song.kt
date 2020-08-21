package com.example.ktn_ak07c01.room.song

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
class Song(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int=0,
    @ColumnInfo(name="id_artist") @NotNull var id_artist:Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "duration") var duration: String
) {

}