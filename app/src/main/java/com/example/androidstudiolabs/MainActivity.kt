package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val setContentMessage = "Hello setContent"
            Column{
                val columnMessage = "Hello Column"
                Row{
                    Text(text = setContentMessage, fontSize = 28.sp)
                }
                Row{
                    Text(text = columnMessage, fontSize = 28.sp)
                }
                Row{
                    val rowMessage = "Hello Row 1"
                    Text(text = rowMessage, fontSize = 28.sp)
                }
                Row{
                    val rowMessage = "Hello Row 2"
                    Text(text = rowMessage, fontSize = 28.sp)
                }

            }
        }
    }
}