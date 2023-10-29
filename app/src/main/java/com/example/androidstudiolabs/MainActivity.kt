package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.androidstudiolabs.ui.theme.AndroidStudioLabsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStudioLabsTheme {
                Text(text = "Hello METANIT.COM!",
                    style = TextStyle(
                        fontSize = 22.sp
                    )
                )
            }
        }
    }
}