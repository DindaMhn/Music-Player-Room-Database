package com.example.ktn_ak07c01.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktn_ak07c01.R
import com.example.ktn_ak07c01.recycleadapter.MusicRecycleAdapter
import com.example.ktn_ak07c01.viewmodel.ArtistViewModel
import kotlinx.android.synthetic.main.fragment_list_music.*

class ListMusicFragment : Fragment(), View.OnClickListener {
    val artistViewModel by activityViewModels<ArtistViewModel>()
    lateinit var navController: NavController
    lateinit var adapter: MusicRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        music_recycleView.layoutManager = LinearLayoutManager(activity)
        artistViewModel.allArtist.observe(viewLifecycleOwner, Observer {
            adapter = MusicRecycleAdapter(it,activity)
            music_recycleView.adapter = adapter
        })
        navController = Navigation.findNavController(view)
        floating_action_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            floating_action_button -> {
                navController.navigate(R.id.action_listMusicFragment_to_inputMusicFragment2)
            }
        }
    }
}
