package com.example.androidstudiolabs.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun DeadInside() {
    val checkedState = remember { mutableStateOf(false) }
    val checkedValue = checkedState.value
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.Top) {
                Checkbox(checked = checkedValue, onCheckedChange = { value -> checkedState.value = value })
                Text(text = "Переключалка", fontSize = 32.sp)
            }
            if (checkedValue) {
                Text(text = "DeadInside mode on", fontSize = 32.sp, textAlign = TextAlign.Center)
            }
        }
    }
}