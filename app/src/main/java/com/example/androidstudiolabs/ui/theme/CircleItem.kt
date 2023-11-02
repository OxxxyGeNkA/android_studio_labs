package com.example.androidstudiolabs.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircleItem() {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.Blue)
    }
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                when (counter.value++) {
                    3 -> color.value = Color.Cyan
                    8 -> color.value = Color.Red
                    11 -> color.value = Color.Green
                    15 -> color.value = Color.Magenta
                    23 -> color.value = Color.Black
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = counter.value.toString(),
            style = TextStyle(color = Color.White, fontSize = 32.sp)
        )
    }
}