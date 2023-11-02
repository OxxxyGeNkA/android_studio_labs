package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar {
                        IconButton(onClick = { }) {Icon(Icons.Filled.Menu, contentDescription = "Меню") }
                        Text("METANIT.COM", fontSize = 22.sp)
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = { }) { Icon(Icons.Filled.Search, contentDescription = "Поиск" ) }
                    }
                },
                bottomBar = {
                    BottomAppBar{
                        IconButton(onClick = {  }) { Icon(Icons.Filled.Favorite, contentDescription = "Избранное")}
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = {  }) { Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")}
                    }
                }
            ){
                Text("Hello Scaffold", fontSize = 28.sp)
            }
        }
    }
}