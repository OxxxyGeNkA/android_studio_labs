package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column{
                val label = remember{ mutableStateOf("")}
                Text(text = label.value, fontSize = 28.sp)
                FloatingActionButton(onClick = {label.value = "Добавлено!" }) {
                    Icon(Icons.Filled.Add, contentDescription = "Добавить")
                }

                val added = remember{ mutableStateOf(false)}
                ExtendedFloatingActionButton(
                    icon = {
                        Icon(
                            if(added.value) Icons.Filled.Delete else Icons.Filled.Add,
                            contentDescription = "Добавить"
                        ) },
                    text = { Text(if(added.value) "Удалить" else "Добавить") },
                    onClick = {added.value = !added.value}
                )
            }
        }
    }
}