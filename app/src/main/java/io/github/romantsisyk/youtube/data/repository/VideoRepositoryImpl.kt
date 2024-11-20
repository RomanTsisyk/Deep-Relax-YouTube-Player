package io.github.romantsisyk.youtube.data.repository

import io.github.romantsisyk.youtube.data.source.remote.RemoteVideoDataSource
import io.github.romantsisyk.youtube.domain.model.Video
import io.github.romantsisyk.youtube.domain.repository.VideoRepository
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