package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()

            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent={
                    ModalDrawerSheet {

                        Text("Пункт меню 1", fontSize = 28.sp)
                        Text("Пункт меню 2", fontSize = 28.sp)
                        Text("Пункт меню 3", fontSize = 28.sp)

                    }
                }
            ){
                Button(onClick = {
                    scope.launch{
                        drawerState.open()
                    }
                }) {
                    Text("Меню", fontSize = 28.sp)
                }
            }
        }
    }
}