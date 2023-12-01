package com.example.androidstudiolabs

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        db = openOrCreateDatabase("P11.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS GAMES (id INTEGER PRIMARY KEY, name TEXT, cost REAL, year INTEGER)")
        db.execSQL("INSERT OR IGNORE INTO GAMES(name, cost, year) VALUES ('GTA V', 2547.35, 2013), ('Project Zomboid', 545.44, 2017), ('DOOM Eternal', 3210.55, 2019)")
        val query: String = "SELECT * FROM GAMES;"

        val cursor: Cursor = db.rawQuery(query, null)
        var games = buildString {
            while (cursor.moveToNext()) {
                var id = cursor.getInt(0)
                var name = cursor.getString(1)
                var cost: Double = cursor.getDouble(2)
                var year: Int = cursor.getInt(3)
                append("$id \t $name \t $cost \t $year\n")
                Log.d(
                    "P11", "NAME: $name COST: $cost YEAR: $year \n!"
                )
            }
        }
        super.onCreate(savedInstanceState)
        setContent {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .padding(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Text(games, modifier = Modifier.verticalScroll(ScrollState(1)))
            }
        }
    }
    override fun onDestroy() {
        db.close()
        deleteDatabase("P11.db")
        super.onDestroy()
    }
}