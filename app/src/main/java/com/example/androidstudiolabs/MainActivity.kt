package com.example.androidstudiolabs

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.androidstudiolabs.ui.theme.DeadInside

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val ghoulMusics = listOf(R.raw.imghoulfull, R.raw.imghoul)
        var ghoulPlayer = MediaPlayer.create(baseContext, R.raw.imghoulfull)
        ghoulPlayer.isLooping = true
        super.onCreate(savedInstanceState)
        setContent {
            val curTrack = remember { mutableListOf(0) }
            var hz = DeadInside()
            if (hz && !ghoulPlayer.isPlaying) {
                ghoulPlayer.start()
            }
            if (!hz && ghoulPlayer.isPlaying) {
                ghoulPlayer.stop()
                ghoulPlayer = MediaPlayer.create(baseContext, ghoulMusics[0])
                ghoulPlayer.isLooping = true
            }
        }
    }
}