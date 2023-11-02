package com.example.androidstudiolabs.ui.theme

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckboxInDaRowAndColumn() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column() {
            val contextRow = LocalContext.current
            var checkedStateRow by remember { mutableStateOf(false) }
            Row(
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 50.dp)
                    .fillMaxWidth()
                    .border(2.dp, Color.Red, RoundedCornerShape(10.dp))
                    .clickable {
                        if (!checkedStateRow) {
                            Toast
                                .makeText(contextRow, "Клик на строке Row Активция", Toast.LENGTH_SHORT)
                                .show()
                        }
                        else {
                            Toast
                                .makeText(contextRow, "Клик на строке Row Деактивация", Toast.LENGTH_SHORT)
                                .show()
                        }
                        checkedStateRow = !checkedStateRow
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checkedStateRow, onCheckedChange = {
                    if (!checkedStateRow) {
                        Toast.makeText(contextRow, "Чекбокс Row нажат Активация", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(contextRow, "Чекбокс Row нажат Деактивация", Toast.LENGTH_SHORT).show()
                    }
                    checkedStateRow = it
                }
                )
                Text(text = "Нажимая на строку, регулируешь чекбокс!", fontSize = 30.sp)
            }

            val contextColumn = LocalContext.current
            var checkedStateColumn by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 50.dp)
                    .fillMaxWidth()
                    .border(2.dp, Color.Red, RoundedCornerShape(10.dp))
                    .clickable {
                        if (!checkedStateColumn) {
                            Toast
                                .makeText(contextColumn, "Клик на строке Column Активция", Toast.LENGTH_SHORT)
                                .show()
                        }
                        else {
                            Toast
                                .makeText(contextColumn, "Клик на строке Column Деактивация", Toast.LENGTH_SHORT)
                                .show()
                        }
                        checkedStateColumn = !checkedStateColumn
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Checkbox(checked = checkedStateColumn, onCheckedChange = {
                    if (!checkedStateColumn) {
                        Toast.makeText(contextColumn, "Чекбокс Column нажат Активация", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(contextColumn, "Чекбокс Column нажат Деактивация", Toast.LENGTH_SHORT).show()
                    }
                    checkedStateColumn = it
                }
                )
                Text(text = "Нажимая на строку, регулируешь чекбокс!", fontSize = 30.sp, textAlign = TextAlign.Center)
            }
        }
    }
}