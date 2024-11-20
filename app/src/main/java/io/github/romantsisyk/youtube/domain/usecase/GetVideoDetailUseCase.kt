package io.github.romantsisyk.youtube.domain.usecase

import io.github.romantsisyk.youtube.domain.model.Video
import io.github.romantsisyk.youtube.domain.repository.VideoRepository

class GetVideoDetailUseCase(private val repository: VideoRepository) {
    suspend fun execute(videoId: String): Video? {
        return repository.getVideoDetail(videoId)
    }
}