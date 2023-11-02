package com.example.androidstudiolabs.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*

@Composable
fun DeadInside() {
    val checkedState = remember { mutableStateOf(false) }
    val checkedValue = checkedState.value
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.fillMaxHeight().weight(1f))
            {
                if (checkedValue) {

                }
            }
            Box(modifier = Modifier.height(60.dp)) {
                if (checkedValue) {
                    Text(
                        text = "DeadInside mode on",
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Box(modifier = Modifier.height(60.dp)) {
                Row(verticalAlignment = Alignment.Top) {
                    Checkbox(
                        checked = checkedValue,
                        onCheckedChange = { value -> checkedState.value = value })
                    Text(text = "Поletmedieм?)", fontSize = 32.sp)
                }
            }
        }
    }
}
