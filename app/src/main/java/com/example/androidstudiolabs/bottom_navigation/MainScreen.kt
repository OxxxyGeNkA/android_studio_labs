package com.example.androidstudiolabs.bottom_navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint( "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val controller = rememberNavController()
    Scaffold (bottomBar = { BottomNavigation(navController = controller) }){
        NavGraph(navHostController = controller)
    }
}