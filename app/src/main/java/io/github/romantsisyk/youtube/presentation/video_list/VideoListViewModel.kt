package io.github.romantsisyk.youtube.presentation.video_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import io.github.romantsisyk.youtube.domain.model.Video
import io.github.romantsisyk.youtube.domain.usecase.FetchVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(private val fetchVideosUseCase: FetchVideosUseCase) :
    ViewModel() {

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos = _videos.asLiveData()

    fun fetchVideos() {
        viewModelScope.launch {
            _videos.value = fetchVideosUseCase.execute()
        }
    }
}