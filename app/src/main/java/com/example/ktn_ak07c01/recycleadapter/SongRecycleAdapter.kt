package com.example.ktn_ak07c01.recycleadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ktn_ak07c01.R
import com.example.ktn_ak07c01.room.PlayList
import com.example.ktn_ak07c01.room.song.Song

class SongRecycleAdapter
    (
    private val songList: PlayList
) :
    RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.playLists.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.titleView.text = songList.playLists[position].title
        holder.durationView.text = songList.playLists[position].duration
        var isPlay: Boolean = true
        holder.playButton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
        holder.playButton.setOnClickListener {
            if (isPlay) {
                holder.playButton.setBackgroundResource(R.drawable.ic_baseline_pause_24)
                isPlay = false
            } else {
                holder.playButton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
                isPlay = true
            }
        }
    }
}

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val titleView = v.findViewById<TextView>(R.id.title_song_detail)
    val durationView = v.findViewById<TextView>(R.id.duration_detail)
    val playButton = v.findViewById<Button>(R.id.playButton)
}