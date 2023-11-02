package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = remember { mutableStateOf(true) }
            Column(Modifier.selectableGroup())
            {
                RadioButton(
                    selected = state.value,
                    onClick = { state.value = true }
                )
                RadioButton(
                    selected = !state.value,
                    onClick = { state.value = false }
                )
            }
        }
    }
}