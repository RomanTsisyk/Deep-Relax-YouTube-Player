package com.roman_tsisyk.youtube.data.repository

import com.roman_tsisyk.youtube.data.source.remote.RemoteVideoDataSource
import com.roman_tsisyk.youtube.domain.model.Video
import com.roman_tsisyk.youtube.domain.repository.VideoRepository
import jakarta.inject.Singleton

@Singleton
class VideoRepositoryImpl(
    private val remoteDataSource: RemoteVideoDataSource
) : VideoRepository {

    override suspend fun fetchVideos(): List<Video> {
        val response = remoteDataSource.fetchVideos()
        return response.videoIds.map { Video(it) }
    }

    override suspend fun getVideoDetail(videoId: String): Video? {
        return fetchVideos().find { it.id == videoId }
    }
}