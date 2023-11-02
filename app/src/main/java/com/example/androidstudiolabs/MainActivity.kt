package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var progress by remember { mutableStateOf(0.0f) }
            val scope = rememberCoroutineScope()

            var progress1 by remember { mutableStateOf(0.0f) }
            val scope1 = rememberCoroutineScope()

            Column{
                Text("Статус: $progress", fontSize = 22.sp)
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            while (progress < 1f) {
                                progress += 0.0004f
                                delay(1L)
                            }
                        }
                    }
                ) {
                    Text("Запустить", fontSize = 22.sp)
                }
                CircularProgressIndicator(progress = progress)
                Box{ CircularProgressIndicator() }

                Text("Статус: $progress1", fontSize = 22.sp)
                OutlinedButton(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        scope1.launch {
                            while (progress1 < 1f) {
                                progress1 += 0.0004f
                                delay(1L)
                            }
                        }
                    }
                ) {
                    Text("Запустить", fontSize = 22.sp)
                }

                LinearProgressIndicator(
                    progress = progress1,
                    color = Color(0xFFD32F2F),
                    trackColor = Color(0xFFEF9A9A)
                )

                LinearProgressIndicator(modifier = Modifier.padding(20.dp))
            }
        }
    }
}