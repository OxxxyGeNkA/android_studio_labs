package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { mutableStateOf(SnackbarHostState()) }
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.value.showSnackbar("Hello")
                    }
                }
            ) {
                Text("Click", fontSize = 28.sp)
            }
            SnackbarHost(snackbarHostState.value)
        }
    }
}