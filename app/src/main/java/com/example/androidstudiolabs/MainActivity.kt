package com.example.androidstudiolabs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.androidstudiolabs.ui.theme.AndroidStudioLabsTheme
import org.json.JSONObject


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp

const val API_KEY = "4049722188974c9c30103d0f7334db13"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStudioLabsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(this)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(context: Context) {
    val state = remember {
        mutableStateOf("0.00")
    }

    var list = listOf(
        "Казань",
        "Москва",
        "Санкт-Петербург",
        "Набережные Челны",
        "Сочи",
        "Уфа",
        "Екатеринбург",
        "Челябинск",
        "Самара",
        "Рязань",
        "Нижний Новгород",
        "Новосибирск",
        "Якутск",
        "Хабаровск"
    )
    list = list.sorted()

    var expanded by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    var selectedCity by remember { mutableStateOf("Казань") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = textFieldValue,
                    onValueChange = { newValue ->
                        textFieldValue = newValue
                    },
                    label = { Text("Select city") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )

                val filteringOptions = list.filter { it.contains(textFieldValue, ignoreCase = true) }
                if (filteringOptions.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                    ) {
                        filteringOptions.forEach { selectedCity_ ->
                            DropdownMenuItem(
                                text = { Text(selectedCity_) },
                                onClick = {
                                    textFieldValue = selectedCity_
                                    expanded = false
                                    selectedCity = selectedCity_
                                    getData(selectedCity, context, state)
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }
            }
            LaunchedEffect(expanded) {
                if (expanded) {
                    scrollState.scrollTo(scrollState.maxValue)
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(0.35f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "$selectedCity", fontSize = 30.sp)
        }

        Box(
            modifier = Modifier
                .weight(0.35f)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(text = "${state.value} Cº", fontSize = 60.sp)
        }

        Box(
            modifier = Modifier
                .weight(0.15f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(onClick = {
                getData(selectedCity, context, state)
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)) {
                Text(text = "Refresh")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidStudioLabsTheme {

    }
}
// api city = NDWsE4BqgEe5j6T9oDx0d9YQuvcGC1
fun getData(name: String, context: Context, mState: MutableState<String>){
    val url = "https://api.openweathermap.org/data/2.5/weather" +
            "?appid=$API_KEY" +
            "&q=$name" +
            "&units=metric"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {
                response->
            val obj = JSONObject(response)
            val main = obj.getJSONObject("main")
            mState.value = main.getString("temp")
        },
        {
            //Log.d("MyLog","Volley error: $it")
        }
    )
    queue.add(stringRequest)
}