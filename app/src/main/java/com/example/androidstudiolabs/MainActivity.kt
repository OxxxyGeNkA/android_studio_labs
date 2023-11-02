package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val selectedItem = remember{ mutableStateOf("")}
            val items = listOf("Главная", "Контакты", "О приложении")
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent={
                    ModalDrawerSheet {
                        for (item in items) {
                            Text(
                                item,
                                fontSize = 28.sp,
                                modifier = Modifier.clickable {
                                    selectedItem.value = item
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                    }
                }
            ){
                Column{
                    Button(onClick = {
                        scope.launch{ drawerState.open() }
                    }) {
                        Text("Меню", fontSize = 28.sp)
                    }
                    Text("Выбран пункт: ${selectedItem.value}", fontSize = 28.sp)
                }
            }
        }
    }
}