package com.example.picturesapi.view

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.picturesapi.databinding.PicItemBinding
import com.example.picturesapi.models.network.model.Image
import com.example.picturesapi.models.repository.PicRepository
import com.example.picturesapi.viewmodel.PicViewModel
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import kotlin.coroutines.coroutineContext

class PicAdapter (
    private val picList: List<Image>
): RecyclerView.Adapter<PicAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PicItemBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(picList[position])
    }

    override fun getItemCount(): Int {
        return picList.size
    }

    class PostViewHolder(private val binding: PicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(img: Image) {
            with(binding) {

                infoTv.text ="Album: ${img.albumId}\nImage: ${img.id}\n${img.title}"

                thumbnailTv.text = img.thumbnailUrl
                Glide.with(PicIv.context).load("${img.url}.png").into(PicIv)
            }

        }
    }

}