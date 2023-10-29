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
            val langs = listOf("Kotlin", "Java", "JavaScript", "Scala")
            Column{
                for(lang in langs){
                    Text(text = lang, fontSize = 28.sp)
                }
            }
        }
    }
}