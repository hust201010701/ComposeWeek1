package com.example.androiddevchallenge.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun MainContent() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") {
            Home(navController)
        }
        composable(
            "detail/{petIndex}",
            arguments = listOf(navArgument("petIndex") { type = NavType.IntType })
        ) {
            Detail(navController, it.arguments?.getInt("petIndex") ?: 0)
        }
    }
}