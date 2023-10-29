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
            Row()
            {
                Box(modifier = Modifier.background(Color.Red).height(150.dp).weight(1f))
                Box(modifier = Modifier.background(Color.Yellow).height(150.dp).width(150.dp))
                Box(modifier = Modifier.background(Color.Green).height(150.dp).weight(2f))
            }
        }
    }
}