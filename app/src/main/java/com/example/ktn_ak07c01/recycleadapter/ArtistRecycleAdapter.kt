package com.example.ktn_ak07c01.recycleadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.ktn_ak07c01.R
import com.example.ktn_ak07c01.room.artist.Artist
import com.squareup.picasso.Picasso

class ArtistRecycleAdapter
    (
    private val musicList: List<Artist>,
    private val getActivity: FragmentActivity?
) :
    RecyclerView.Adapter<MusicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_item_layout, parent, false)
        return MusicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.nameView.text = musicList[position].name
        holder.titleView.text = musicList[position].title
        Picasso.with(getActivity).load(musicList[position].image).into(holder.imageViewURL)
        val bundle = bundleOf(
            Pair("title", musicList[position].title), Pair("image", musicList[position].image),
            Pair("id", musicList[position].artist_id.toString())
        )
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_listMusicFragment_to_detailMusicFragment, bundle)
        }
    }
}

class MusicViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val nameView = v.findViewById<TextView>(R.id.nameView)
    val titleView = v.findViewById<TextView>(R.id.titleView)
    val imageViewURL: ImageView = v.findViewById(R.id.imageViewURL)
}