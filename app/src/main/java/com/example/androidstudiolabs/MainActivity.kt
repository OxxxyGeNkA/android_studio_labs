package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Hello (Center)", modifier = Modifier.fillMaxWidth(1f) ,  fontSize=22.sp, textAlign = TextAlign.Center)
                Text(text = "Hello (Justify)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Justify)
                Text(text = "Hello (Left)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Left)
                Text(text = "Hello (Right)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Right)
                Text(text = "Hello (Start)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.Start)
                Text(text = "Hello (End)", modifier = Modifier.fillMaxWidth(1f),  fontSize=22.sp, textAlign = TextAlign.End)
            }
        }
    }
}