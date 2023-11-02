package com.example.androidstudiolabs

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidstudiolabs.ui.theme.DeadInside

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var ghoulPlayer = MediaPlayer.create(baseContext, R.raw.imghoulfull)
        ghoulPlayer.isLooping = true
        super.onCreate(savedInstanceState)
        setContent {
            var hz = DeadInside()
            if (hz && !ghoulPlayer.isPlaying) {
                ghoulPlayer.start()
            }
            if (!hz && ghoulPlayer.isPlaying) {
                ghoulPlayer.stop()
                ghoulPlayer = MediaPlayer.create(baseContext, R.raw.imghoulfull)
                ghoulPlayer.isLooping = true
            }
        }
    }
}