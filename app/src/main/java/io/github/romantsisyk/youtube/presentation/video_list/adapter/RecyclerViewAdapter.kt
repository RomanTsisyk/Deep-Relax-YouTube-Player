package io.github.romantsisyk.youtube.presentation.video_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roman_tsisyk.youtube.R

internal class RecyclerViewAdapter(
    private val videoIds: List<String>
) : RecyclerView.Adapter<YouTubePlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubePlayerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return YouTubePlayerViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: YouTubePlayerViewHolder, position: Int) {
        viewHolder.cueVideo(videoIds[position])
    }

    override fun getItemCount() = videoIds.size
}