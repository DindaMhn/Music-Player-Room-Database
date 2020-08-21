package com.example.ktn_ak07c01.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktn_ak07c01.R
import com.example.ktn_ak07c01.recycleadapter.SongRecycleAdapter
import com.example.ktn_ak07c01.viewmodel.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_music.*
import kotlinx.android.synthetic.main.fragment_detail_music.music_recycleView
import kotlinx.android.synthetic.main.fragment_list_music.*
import kotlinx.android.synthetic.main.song_item_layout.*

class DetailMusicFragment : Fragment(), View.OnClickListener {
    val songViewModel by activityViewModels<SongViewModel>()
    lateinit var navController: NavController
    lateinit var adapter: SongRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title_detail.text = arguments?.getString("title")
        Picasso.with(this.context).load(arguments?.getString("image")).into(image_detail)
        music_recycleView.layoutManager = LinearLayoutManager(activity)
        songViewModel.getAllSong(arguments?.getString("id")!!.toInt()).observe(viewLifecycleOwner, Observer {
            adapter = SongRecycleAdapter(it)
            music_recycleView.adapter = adapter
        })
        navController = Navigation.findNavController(view)
        floating_action_button_detail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val bundle = bundleOf(Pair("song_id", arguments?.getString("id")))
        when (v) {
            floating_action_button_detail -> {
                navController.navigate(R.id.action_detailMusicFragment_to_inputSongFragment, bundle)
            }
        }
    }
}