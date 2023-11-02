package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var expanded by remember { mutableStateOf(false) }
            var selectedOption by remember { mutableStateOf("") }
            Column{
                Text("Выбран пункт: $selectedOption")
                Box {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Показать меню")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(onClick = { selectedOption="Copy"}, text = {Text("Скопировать")})
                        DropdownMenuItem(onClick = { selectedOption="Paste"}, text = {Text("Вставить")})
                        Divider()
                        DropdownMenuItem(onClick = { selectedOption="Settings"}, text = {Text("Настройки")})
                    }
                }
            }

        }
    }
}
