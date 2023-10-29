package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column()
            {
                Box(modifier = Modifier.background(Color.Red).fillMaxWidth().weight(1f))
                Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().weight(3f))
                Box(modifier = Modifier.background(Color.Green).fillMaxWidth().weight(2f))
            }
        }
    }
}