package com.roman_tsisyk.youtube.di

import com.google.gson.Gson
import com.roman_tsisyk.youtube.data.repository.VideoRepositoryImpl
import com.roman_tsisyk.youtube.data.source.remote.RemoteVideoDataSource
import com.roman_tsisyk.youtube.domain.repository.VideoRepository
import com.roman_tsisyk.youtube.domain.usecase.FetchVideosUseCase
import com.roman_tsisyk.youtube.domain.usecase.GetVideoDetailUseCase
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