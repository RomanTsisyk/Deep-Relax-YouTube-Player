package com.roman_tsisyk.youtube.presentation.video_list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.roman_tsisyk.youtube.R

class YouTubePlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var youTubePlayer: YouTubePlayer? = null
    private var currentVideoId: String? = null
    private val youTubePlayerView = view.findViewById<YouTubePlayerView>(R.id.youtube_player_view).apply {
        enableBackgroundPlayback(true)
    }
    private val overlayView = view.findViewById<View>(R.id.overlay_view)

    init {
        overlayView.setOnClickListener { youTubePlayer?.play() }
        youTubePlayerView.addYouTubePlayerListener(getYouTubePlayerListener())
    }

    fun cueVideo(videoId: String) {
        currentVideoId = videoId
        youTubePlayer?.cueVideo(videoId, 0f)
    }

    private fun getYouTubePlayerListener() = object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            this@YouTubePlayerViewHolder.youTubePlayer = youTubePlayer
            currentVideoId?.let { youTubePlayer.cueVideo(it, 0f) }
        }

        override fun onStateChange(
            youTubePlayer: YouTubePlayer,
            state: PlayerConstants.PlayerState
        ) {
            when (state) {
                PlayerConstants.PlayerState.VIDEO_CUED -> overlayView.show()
                else -> overlayView.hide()
            }
        }
    }

    private fun View.show() {
        this.visibility = View.VISIBLE
    }

    private fun View.hide() {
        this.visibility = View.GONE
    }
}