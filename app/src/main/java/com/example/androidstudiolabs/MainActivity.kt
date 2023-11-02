package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val colors = listOf(Color.Red, Color.Green, Color.Blue)
            val selectedOption = remember { mutableStateOf(colors[0]) }
            Column(modifier =Modifier.padding(20.dp)) {
                Box( Modifier.padding(10.dp).size(100.dp).background(color = selectedOption.value))

                colors.forEach { color ->
                    val selected = selectedOption.value == color
                    Box(
                        Modifier.padding(8.dp)
                            .size(60.dp)
                            .background(color = color)
                            .selectable(
                                selected = selected,
                                onClick = { selectedOption.value = color }
                            )
                            .border(
                                width= if(selected){2.dp} else{0.dp},
                                color = Color.Black
                            )
                    )
                }
            }
        }
    }
}