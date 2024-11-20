package io.github.romantsisyk.youtube.domain.repository

import io.github.romantsisyk.youtube.domain.model.Video

interface VideoRepository {
    suspend fun fetchVideos(): List<Video>
    suspend fun getVideoDetail(videoId: String): Video?
}