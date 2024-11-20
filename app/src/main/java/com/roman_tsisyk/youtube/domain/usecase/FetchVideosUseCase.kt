package com.roman_tsisyk.youtube.domain.usecase

import com.roman_tsisyk.youtube.domain.model.Video
import com.roman_tsisyk.youtube.domain.repository.VideoRepository

class FetchVideosUseCase(private val repository: VideoRepository) {
    suspend fun execute(): List<Video> {
        return repository.fetchVideos()
    }
}