package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Cursive)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Monospace)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.SansSerif)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Serif)
                Text(text = "Hello Jetpack Compose!",  fontSize=22.sp, fontFamily=FontFamily.Default)
            }
        }
    }
}