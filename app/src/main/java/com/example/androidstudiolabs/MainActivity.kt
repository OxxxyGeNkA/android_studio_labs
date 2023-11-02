package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            val count = remember{ mutableStateOf(0) }
            Scaffold(
                snackbarHost = {
                    SnackbarHost(snackbarHostState){ data ->
                        Snackbar(
                            modifier = Modifier.padding(10.dp),
                            containerColor = Color(0xFF004D40),
                            contentColor = Color(0xFFB2DFDB),
                            action = {
                                TextButton(onClick={ data.performAction() }){
                                    Text("Add click", fontSize=22.sp, color=Color(0xFFB2DFDB))
                                }
                            }
                        ){
                            Text("Clicks count: ${count.value}", fontSize=26.sp)
                        }
                    }
                }
            ){
                innerPadding ->
                Button(
                    onClick = {
                        scope.launch {
                            val result = snackbarHostState.showSnackbar("")
                            if(result==SnackbarResult.ActionPerformed) count.value++
                        }
                    }
                ){
                    Text("Click", fontSize = 28.sp, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}