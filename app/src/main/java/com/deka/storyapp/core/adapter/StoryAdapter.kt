package com.deka.storyapp.core.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deka.storyapp.R
import com.deka.storyapp.core.data.remote.response.StoryData
import com.deka.storyapp.core.utils.getDate
import com.deka.storyapp.databinding.StoryItemBinding
import com.deka.storyapp.ui.DetailActivity

class StoryAdapter: ListAdapter<StoryData,StoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(StoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: StoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(story: StoryData) {
            binding.apply {
                nameStory.text = story.name
                descriptionText.text = story.description
                dateText.text = getDate(story.createdAt)
                Glide.with(itemView.context)
                    .load(story.photoUrl)
//                    .placeholder(R.drawable.)
                    .into(imageStory)

                val moveDetail = Intent(itemView.context, DetailActivity::class.java)
                moveDetail.putExtra("story", story)

            }

        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<StoryData>() {
            override fun areItemsTheSame(oldItem: StoryData, newItem: StoryData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: StoryData, newItem: StoryData): Boolean {
                return oldItem == newItem
            }
        }
    }

}