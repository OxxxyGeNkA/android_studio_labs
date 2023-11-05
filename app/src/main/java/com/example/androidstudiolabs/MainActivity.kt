package com.example.androidstudiolabs

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.androidstudiolabs.ui.theme.AndroidStudioLabsTheme
import org.json.JSONObject

const val API_KEY = "4049722188974c9c30103d0f7334db13"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidStudioLabsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Kazan", this)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, context: Context) {
    val state = remember {
        mutableStateOf("Unknown")
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Temperature in $name: ${state.value} Cº")
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(onClick = {
                getData(name, context, state)
            }, modifier = Modifier.fillMaxWidth().padding(5.dp)) {
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

fun getData(name: String, context: Context, mState: MutableState<String>){
    /*val url = "https://api.openweathermap.org/data/2.5/forecast/daily" +
            "?appid=$API_KEY" +
            "&q=$name" +
            "&units=metric" +
            "&cnt=1"*/
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

            //val list = obj.getJSONArray("list")
            //val temp = list.getJSONObject(0).getJSONObject("temp")
            //val tempday = temp.getString("day")
            //mState.value = temp.getString("day")
            //Log.d("MyLog","Response: ${temp.getString("temp_c")}")

            val main = obj.getJSONObject("main")
            mState.value = main.getString("temp")
        },
        {
            //Log.d("MyLog","Volley error: $it")
        }
    )
    queue.add(stringRequest)
}