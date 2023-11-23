package com.example.androidstudiolabs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Screen4() {
    var i by rememberSaveable {
        mutableStateOf(0)
    }
    Text(
        text = "Клики: $i",
        modifier = Modifier.clickable(onClick = { i++ } )
    )
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