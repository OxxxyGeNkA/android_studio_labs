package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val (value, setValue) = remember{mutableStateOf("Hello Jetpack")}

            Text(
                text = value,
                fontSize = 28.sp,
                modifier = Modifier.clickable( onClick = { setValue("Hello Metanit.com")})
            )
        }
    }
}