package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MyViewModel2 : ViewModel() {
    var i = mutableStateOf(0)
        private set
    fun increment() {
        i.value++
    }
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen2()
        }
    }
}

@Composable
fun Screen2(myViewModel: MyViewModel2 = viewModel()) {
    val i by myViewModel.i
    Text(
        text = "Клики: $i",
        modifier = Modifier.clickable(onClick = myViewModel::increment)
    )
}