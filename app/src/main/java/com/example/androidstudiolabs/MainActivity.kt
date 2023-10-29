package com.example.androidstudiolabs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message = mutableStateOf("Hello Jetpack")

            Text(
                text = message.value,
                fontSize = 28.sp,
                modifier = Modifier.clickable( onClick = { message.value = "Hello Work!" })
            )
        }
    }
}