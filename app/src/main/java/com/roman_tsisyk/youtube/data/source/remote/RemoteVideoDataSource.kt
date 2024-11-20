package com.roman_tsisyk.youtube.data.source.remote

import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import com.roman_tsisyk.youtube.data.model.GithubVideoResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response
import java.io.IOException

class RemoteVideoDataSource(
    private val client: OkHttpClient,
    private val gson: Gson,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchVideos(): GithubVideoResponse {
        return withContext(dispatcher) {
            val request = Request.Builder()
                .url("$BASE_URL$PATH_TO_FILE")
                .build()
            val response = client.newCall(request).execute()
            handleResponse(response)
        }
    }

    private fun handleResponse(response: Response): GithubVideoResponse {
        val responseBody = response.body?.string()

        var result = GithubVideoResponse(emptyList())
        if (response.isSuccessful && !responseBody.isNullOrEmpty()) {
            try {
                result = gson.fromJson(responseBody, GithubVideoResponse::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return result
    }

    companion object {
        private const val YOUR_GITHUB_USERNAME = "RomanTsisyk"
        private const val REPO_NAME = "YTubeBackplay"
        private const val BRANCH_NAME = "master"
        private const val PATH_TO_FILE = "/test_youtube.json"
        private const val BASE_URL =
            "https://raw.githubusercontent.com/$YOUR_GITHUB_USERNAME/$REPO_NAME/$BRANCH_NAME"

    }
}