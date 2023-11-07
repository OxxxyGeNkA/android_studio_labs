package com.example.androidstudiolabs

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.androidstudiolabs.ui.theme.AndroidStudioLabsTheme
import com.example.androidstudiolabs.ui.theme.DeadInside

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val ghoulMusics = listOf(R.raw.imghoulfull, R.raw.femlove_zakat, R.raw.femlove_993, R.raw.femlove_pain, R.raw.kute_avoid_me)
        val fastMusic = listOf(R.raw.blyad_da_vi_ahueli, R.raw.zatknis_shluha, R.raw.smert, R.raw.pepsikolniy, R.raw.ya_siel_deda)
        var ghoulPlayer = MediaPlayer.create(baseContext, ghoulMusics[0])
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStudioLabsTheme (darkTheme = false){
                val curTrack = remember { mutableStateOf(0) }
                val onPause = remember { mutableStateOf(false) }
                var hz = DeadInside()
                if (hz && !ghoulPlayer.isPlaying) {

                    if (!onPause.value) {
                        ghoulPlayer = MediaPlayer.create(baseContext, ghoulMusics[curTrack.value])
                    }
                    //ghoulPlayer = MediaPlayer.create(baseContext, fastMusic[curTrack.value])
                    ghoulPlayer.start()
                    ghoulPlayer.setOnCompletionListener {
                        curTrack.value += 1
                        if (curTrack.value == 5) {
                            curTrack.value = 0
                        }
                        onPause.value = false
                    }
                    //Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
                }


                if (!hz && ghoulPlayer.isPlaying) {
                    //Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
                    ghoulPlayer.pause()
                    onPause.value = true
                    //ghoulPlayer = MediaPlayer.create(baseContext, ghoulMusics[0])
                }
            }
        }
    }
}