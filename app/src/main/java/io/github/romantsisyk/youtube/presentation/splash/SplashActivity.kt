package io.github.romantsisyk.youtube.presentation.splash

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.github.romantsisyk.youtube.presentation.video_list.VideoListActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        startActivity(Intent(this, VideoListActivity::class.java))
        finish()
    }
}
