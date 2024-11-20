package com.roman_tsisyk.youtube.domain.usecase

import com.roman_tsisyk.youtube.domain.model.Video
import com.roman_tsisyk.youtube.domain.repository.VideoRepository

class GetVideoDetailUseCase(private val repository: VideoRepository) {
    suspend fun execute(videoId: String): Video? {
        return repository.getVideoDetail(videoId)
    }
}