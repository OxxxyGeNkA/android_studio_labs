package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column{
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 28.sp
                )
                Text(
                    text = stringResource(R.string.message),
                    fontSize = 28.sp
                )
                Text(
                    text = stringResource(R.string.welcome),
                    fontSize = 28.sp
                )
                Button(onClick={}){
                    Text(
                        text = stringResource(R.string.click_button),
                        fontSize = 22.sp
                    )
                }
                Text(
                    text = stringResource(R.string.user_data, "Tom", 37, "JetBrains"),
                    fontSize = 28.sp
                )
                Text(
                    text = stringResource(R.string.user_data, "Bob", 41, "Google"),
                    fontSize = 28.sp
                )
                /*Text(
                    text = resources.getQuantityString(R.plurals.flowers, 21, 21),
                    fontSize = 22.sp
                )
                Text(
                    text = resources.getQuantityString(R.plurals.flowers, 7, 7),
                    fontSize = 22.sp
                )*/
            }
        }
    }
}