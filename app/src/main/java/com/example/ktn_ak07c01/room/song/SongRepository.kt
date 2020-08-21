package com.example.ktn_ak07c01.room.song


class SongRepository(private val songDao: SongDao) {
    //    val allSong: LiveData<PlayList> = songDao.getAllSong(id_artist)
    fun getAllSong(id: Int) = songDao.getAllSong(id)
    fun createSong(song: Song) {
        songDao.createSong(song)
    }
}