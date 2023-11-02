package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val openDialog = remember { mutableStateOf(false) }
            Button(
                onClick = { openDialog.value = true }
            ) {
                Text("Удалить", fontSize = 22.sp)
            }
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = { Text(text = "Подтверждение действия") },
                    text = { Text("Вы действительно хотите удалить выбранный элемент?") },
                    confirmButton = {
                        Button(

                            onClick = { openDialog.value = false }
                        ) {
                            Text("Удалить")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = { openDialog.value = false }
                        ) {
                            Text("Отмена")
                        }
                    }
                )
            }
        }
    }
}