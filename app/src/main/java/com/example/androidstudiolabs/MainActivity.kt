package com.example.androidstudiolabs

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.androidstudiolabs.ui.theme.DeadInside

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val ghoulMusics = listOf(R.raw.imghoulfull, R.raw.femlove_zakat, R.raw.femlove_993, R.raw.femlove_pain, R.raw.kute_avoid_me)
        var ghoulPlayer = MediaPlayer.create(baseContext, R.raw.imghoulfull)
        ghoulPlayer.isLooping = true
        super.onCreate(savedInstanceState)
        setContent {
            val curTrack = remember { mutableStateOf(0) }
            var hz = DeadInside()
            ghoulPlayer.setOnCompletionListener {
                ghoulPlayer.stop()
            }
            if (hz && !ghoulPlayer.isPlaying) {
                ghoulPlayer = MediaPlayer.create(baseContext, ghoulMusics[curTrack.value])
                ghoulPlayer.start()
                curTrack.value += 1
                if (curTrack.value == 5) {
                    curTrack.value = 0
                }
            }
            if (!hz && ghoulPlayer.isPlaying) {
                ghoulPlayer.stop()
                //ghoulPlayer = MediaPlayer.create(baseContext, ghoulMusics[0])
            }
        }
    }
}