package com.deka.storyapp.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deka.storyapp.R
import com.deka.storyapp.core.data.remote.response.StoryData

class StoryAdapter: RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    private val storyList = ArrayList<StoryData>()
    var onItemClick: ((StoryData) -> Unit)? = null

    fun setData(listStory: List<StoryData>?) {
        if (listStory == null) return
        storyList.clear()
        storyList.addAll(listStory)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.story_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(storyList[position])
    }

    override fun getItemCount(): Int = storyList.size

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(story: StoryData) {
            with(itemView) {

            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(storyList[position])
            }
        }
    }

}