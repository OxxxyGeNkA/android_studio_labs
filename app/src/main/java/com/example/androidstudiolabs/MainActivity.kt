package com.example.androidstudiolabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidstudiolabs.ui.theme.Book
import com.example.androidstudiolabs.ui.theme.MyViewModel

class MainActivity : ComponentActivity() {
    val vm: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen(vm.books)
        }
    }
}

@Composable
fun MyScreen(books: List<Book>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        contentPadding = PaddingValues(16.dp),

        modifier = Modifier
            .border(3.dp, Color.Gray)
            .padding(10.dp)
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Book",
                    Modifier.fillMaxWidth(0.5f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Author",
                    Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(books) {
            BookItem(it)
        }
    }
}
@Composable
fun BookItem(bookModel: Book) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(), elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = bookModel.name,
                modifier = Modifier.fillMaxWidth(0.45f),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier.fillMaxWidth(0.1f)){}
            Text(
                text = bookModel.author,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}