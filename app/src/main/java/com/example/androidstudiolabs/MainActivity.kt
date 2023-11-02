package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isAdded = remember{ mutableStateOf(false) }
            Scaffold(
                topBar = { TopAppBar({Text("METANIT.COM", fontSize = 22.sp)})},
                bottomBar = {
                    BottomAppBar{
                        IconButton(onClick = {  }) { Icon(Icons.Filled.Menu, contentDescription = "Меню")}
                        Spacer(Modifier.weight(1f, true))
                        IconButton(onClick = {  }) { Icon(Icons.Filled.Search, contentDescription = "Поиск")}
                    }
                },
                floatingActionButtonPosition = FabPosition.Center,
                floatingActionButton = {
                    FloatingActionButton(
                        content = {
                            if(isAdded.value) Icon(Icons.Filled.Clear, contentDescription = "Удалить")
                            else Icon(Icons.Filled.Add, contentDescription = "Добавить") },
                        onClick = { isAdded.value = !isAdded.value}
                    )
                }
            ){
                    innerPadding -> Text(text = if(isAdded.value) "Товар добавлен" else "Корзина пуста", fontSize = 28.sp, modifier = Modifier.padding(innerPadding))
            }
        }
    }
}