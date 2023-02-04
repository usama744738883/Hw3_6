package com.geektech.playlistrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.playlistrv.databinding.ItemMusicBinding
import javax.microedition.khronos.opengles.GL

class MusicAdapter(private val songList: List<Song>, val onClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(
            ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(songList[position])
    }

    override fun getItemCount() = songList.size

    inner class MusicViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Song) {

            itemView.setOnClickListener{
                onClick(adapterPosition)
            }

            binding.tvSongNumber.text = (adapterPosition + 1).toString()
            binding.tvSongName.text = song.name
            binding.tvSongArtist.text = song.artist
            binding.tvSongDuration.text = song.duration

            Glide.with(binding.ivSongImage).load(song.image).into(binding.ivSongImage)
        }

    }
}