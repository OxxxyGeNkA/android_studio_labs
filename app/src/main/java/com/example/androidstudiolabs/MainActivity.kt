package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(
                    text = "Все мы сейчас желаем кушать, потому что утомились",
                    fontSize = 22.sp,
                    style = TextStyle(textGeometricTransform = TextGeometricTransform(0.5f))
                )
                Text(
                    text = "Все мы сейчас желаем кушать, потому что утомились",
                    fontSize = 22.sp,
                    style = TextStyle(textGeometricTransform = TextGeometricTransform(1.5f))
                )
            }
        }
    }
}