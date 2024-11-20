package io.github.romantsisyk.youtube.di

import com.google.gson.Gson
import io.github.romantsisyk.youtube.data.repository.VideoRepositoryImpl
import io.github.romantsisyk.youtube.data.source.remote.RemoteVideoDataSource
import io.github.romantsisyk.youtube.domain.repository.VideoRepository
import io.github.romantsisyk.youtube.domain.usecase.FetchVideosUseCase
import io.github.romantsisyk.youtube.domain.usecase.GetVideoDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
//    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
//    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
//    @Singleton
    fun provideRemoteVideoDataSource(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): RemoteVideoDataSource {
        return RemoteVideoDataSource(okHttpClient, gson)
    }

    @Provides
//    @Singleton
    fun provideVideoRepository(remoteVideoDataSource: RemoteVideoDataSource): VideoRepository {
        return VideoRepositoryImpl(remoteVideoDataSource)
    }

    @Provides
    fun provideFetchVideosUseCase(repository: VideoRepository): FetchVideosUseCase {
        return FetchVideosUseCase(repository)
    }

    @Provides
    fun provideGetVideoDetailUseCase(repository: VideoRepository): GetVideoDetailUseCase {
        return GetVideoDetailUseCase(repository)
    }
}