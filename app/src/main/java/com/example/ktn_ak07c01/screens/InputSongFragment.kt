package com.example.ktn_ak07c01.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.ktn_ak07c01.R
import com.example.ktn_ak07c01.room.song.Song
import com.example.ktn_ak07c01.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_input_song.*

class InputSongFragment : Fragment(), View.OnClickListener {
    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveButtonSong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            saveButtonSong -> {
                val title = song_title.text.toString()
                val duration = duration.text.toString()
                val id = arguments?.getString("song_id")!!.toInt()
                if (title == "" || duration == "") {
                    Toast.makeText(this.context, "Must be Field", Toast.LENGTH_SHORT).show()
                } else {
                    songViewModel.createNewSong(
                        Song(
                            title = title,
                            duration = duration,
                            id_artist = id
                        )
                    )
                    Toast.makeText(this.context, "Data Successfull Added", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}