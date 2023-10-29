package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween )
            {
                Box(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
                Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
                Box(modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
            }
        }
    }
}