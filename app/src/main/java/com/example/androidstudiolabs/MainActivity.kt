package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text("Hello", style = TextStyle(fontSize = 22.sp))
                Text("World", style = TextStyle(fontSize = 22.sp))
                Text("from", style = TextStyle(fontSize = 22.sp))
                Text("Jetpack Compose", style = TextStyle(fontSize = 22.sp))
            }
        }
    }
}