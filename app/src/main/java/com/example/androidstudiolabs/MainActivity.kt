package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sliderPosition by remember{mutableStateOf(0f)}
            Column{
                Text(text = "Текущее значение: ${sliderPosition}", fontSize = 22.sp)
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it }
                )
            }
        }
    }
}