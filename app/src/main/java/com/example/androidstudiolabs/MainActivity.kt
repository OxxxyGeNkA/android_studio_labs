package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val hour = 19
            if(hour < 18) {
                Text(text = "Добрый день", fontSize = 28.sp)
            }
            else{
                Column{
                    Text(text = "Добрый", fontSize = 23.sp)
                    Text(text = "вечер", fontSize = 23.sp)
                }
            }
        }
    }
}