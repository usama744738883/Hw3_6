package com.geektech.playlistrv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.geektech.playlistrv.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var dataFromMainFragment: Song

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataFromMainFragment = arguments?.getSerializable("key") as Song

        binding.tvNameSecond.text = dataFromMainFragment.name
        binding.tvArtistSecond.text = dataFromMainFragment.artist
        Glide.with(binding.ivImgageSecond).load(dataFromMainFragment.image).into(binding.ivImgageSecond)
    }

}