package com.example.ktn_ak07c01.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ktn_ak07c01.room.artist.Artist
import com.example.ktn_ak07c01.room.artist.ArtistDao
import com.example.ktn_ak07c01.room.song.Song
import com.example.ktn_ak07c01.room.song.SongDao

@Database(entities = arrayOf(Artist::class, Song::class), version = 3, exportSchema = false)
public abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun artistDao(): ArtistDao
    abstract fun songDao(): SongDao

    companion object {
        private var DATABASE_INSTANCE: AppRoomDatabase? = null

        fun getDatabaseInstance(context: Context): AppRoomDatabase {
            if (DATABASE_INSTANCE != null) {
                return DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE =
                Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "spotify database"
                ).fallbackToDestructiveMigration().build()
            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}