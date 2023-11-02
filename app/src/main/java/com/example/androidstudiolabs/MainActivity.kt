package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            val count = remember{ mutableStateOf(0) }
            Scaffold(
                snackbarHost = { SnackbarHost(snackbarHostState) },
                floatingActionButton = {
                    FloatingActionButton(
                        content = {Icon(Icons.Filled.Add, contentDescription = "Добавить")},
                        onClick = {
                            scope.launch {
                                val result = snackbarHostState.showSnackbar("Count: ${count.value}", "Click")
                                when (result) {
                                    SnackbarResult.ActionPerformed -> { count.value++; }
                                    SnackbarResult.Dismissed -> { count.value--; }
                                }
                            }
                        }
                    )
                }
            ){
                    innerPadding -> Text("Count", Modifier.padding(innerPadding), fontSize = 28.sp)
            }
        }
    }
}