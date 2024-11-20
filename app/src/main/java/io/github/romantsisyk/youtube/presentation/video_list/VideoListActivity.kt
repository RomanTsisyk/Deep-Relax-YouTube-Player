package io.github.romantsisyk.youtube.presentation.video_list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roman_tsisyk.youtube.R
import io.github.romantsisyk.youtube.presentation.video_list.adapter.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class VideoListActivity : AppCompatActivity() {

    private val viewModel: VideoListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(this@VideoListActivity)
        }

        viewModel.videos.observe(this) { videos ->
            recyclerView.adapter = RecyclerViewAdapter(videos.map { it.id })
        }

        viewModel.fetchVideos()
    }
}