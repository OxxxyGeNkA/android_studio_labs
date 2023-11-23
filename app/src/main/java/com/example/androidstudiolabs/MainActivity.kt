package com.example.androidstudiolabs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlin.math.abs

@Composable
fun Screen4() {
    var i by rememberSaveable {
        mutableStateOf(0)
    }
    val size = 20 + abs(i % 40 - 20) * 2
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Клики: $i",
            modifier = Modifier.clickable(onClick = { i++ } ),
            fontSize = size.sp
        )
    }
}
class MainActivity : ComponentActivity() {
    private val TAG = "♂GAYSEXXX♂"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen4()
            Log.d(TAG, "Код сделал ♂Fisting ass♂")
        }
    }
}