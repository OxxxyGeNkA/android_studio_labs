package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
//import androidx.compose.foundation.
import androidx.compose.ui.unit.TextUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message = "Hello Metanit.com"
            val size: TextUnit = 28.sp
            Text(
                text = message,
                fontSize = size
            )
        }
    }
}