package com.geektech.playlistrv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.geektech.playlistrv.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var songList = arrayListOf<Song>()
    private var bundle = Bundle()
    private var fragment:SecondFragment = SecondFragment()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        songList.clear()
        loadData()

        val musicAdapter = MusicAdapter(songList, this::onClick)
        binding.rvMusicList.adapter = musicAdapter
    }

    fun onClick(position:Int){

        bundle.putSerializable("key", songList[position])
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).addToBackStack(null).commit()

    }

    private fun loadData(){
        songList.add(Song("I got love", "Miyagi","4:44","https://i.ytimg.com/vi/-CiTVT2_Ntg/hqdefault.jpg"))
        songList.add(Song("Bakr", "Oilorumda","2:46","https://i.ytimg.com/vi/cFJ5M0ztKg0/maxresdefault.jpg"))
        songList.add(Song("All want is you", "Rebzyyx","2:32","https://i.scdn.co/image/ab67616d0000b2732959e0d1c28414c8e003e43d"))
        songList.add(Song("Fire man", "Miyagi", "3:30", "https://i1.sndcdn.com/artworks-000420873333-egu1s6-t500x500.jpg"))
        songList.add(Song("Grateful", "Neffex", "4:02","https://i.scdn.co/image/ab67616d0000b27391b467ab179bd199b2fbc3d9"))
        songList.add(Song("Comeback", "Neffex", "3:02","https://i.ytimg.com/vi/JOQUnRjdqKA/maxresdefault.jpg"))
        songList.add(Song("life", "Neffex", "2:00","https://i1.sndcdn.com/artworks-000262784603-x8a3rz-t500x500.jpg"))
        songList.add(Song("Soldier", "Neffex", "2:00","https://i1.sndcdn.com/artworks-000245573137-3ho5e4-t500x500.jpg"))
        songList.add(Song("Chance", "Neffex", "3:07","https://i.ytimg.com/vi/WzQBAc8i73E/maxresdefault.jpg"))
        songList.add(Song("Cold", "Neffex", "3:00","https://i.ytimg.com/vi/WzQBAc8i73E/maxresdefault.jpg"))
        songList.add(Song("Best of me", "Neffex", "3:54","https://i.ytimg.com/vi/A4LiP8WFuG0/maxresdefault.jpg"))
        songList.add(Song("Careless", "Neffex", "4:57","https://i.pinimg.com/originals/9e/46/02/9e460231ebe09200864d9014d7e8dc67.jpg"))
        songList.add(Song("Play", "Neffex", "2:15","https://i.ytimg.com/vi/aH6-bVcUXcg/maxresdefault.jpg"))
        songList.add(Song("Boy with luv", "BTS", "3:30", "https://media.gq.com/photos/5caa2d23d3d6e841f3616418/4:3/w_1024,h_768,c_limit/Screenshot%202019-04-07%20at%201.02.05%20PM.png"))
 }
}