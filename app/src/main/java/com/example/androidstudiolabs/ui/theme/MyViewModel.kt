package com.example.androidstudiolabs.ui.theme

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.github.javafaker.Faker

class MyViewModel : ViewModel() {
    val books: MutableList<Book> = (1..100).map {
        Book(
            Faker().book().title(),
            Faker().book().author()
        )
    }.toMutableStateList()
}
