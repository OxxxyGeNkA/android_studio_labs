package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val selected = remember { mutableStateOf(true) }

            Text(
                text= selected.value.toString(),
                fontSize = 30.sp,
                modifier = Modifier.selectable(
                    selected = selected.value,
                    onClick = { selected.value = !selected.value }
                )
            )
        }
    }
}