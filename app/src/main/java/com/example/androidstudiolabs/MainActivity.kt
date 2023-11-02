package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Button(onClick = {},)
            {
                Column{
                    Text("Button Header", fontSize = 30.sp)
                    Text("Button Text", fontSize = 22.sp)
                    Text("Button footer", fontSize = 18.sp)
                }
            }
        }
    }
}