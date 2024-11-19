package com.roman_tsisyk.youtube.domain.repository

import com.roman_tsisyk.youtube.domain.model.Video

interface VideoRepository {
    suspend fun fetchVideos(): List<Video>
    suspend fun getVideoDetail(videoId: String): Video?
}