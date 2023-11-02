package com.example.androidstudiolabs.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun MyText1(i: State<Int>, lambdaForClick: () -> Unit) {
    val iValue = i.value
    val bonus : Int = iValue / 5
    val points = iValue + bonus
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Кликов: $iValue \nОчков: $points",
            modifier = Modifier.clickable(onClick = lambdaForClick),
            fontSize = 32.sp
        )
    }


}
