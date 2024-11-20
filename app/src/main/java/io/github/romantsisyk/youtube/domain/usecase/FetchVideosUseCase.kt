package io.github.romantsisyk.youtube.domain.usecase

import io.github.romantsisyk.youtube.domain.model.Video
import io.github.romantsisyk.youtube.domain.repository.VideoRepository

class FetchVideosUseCase(private val repository: VideoRepository) {
    suspend fun execute(): List<Video> {
        return repository.fetchVideos()
    }
}