package com.example.navigationdrawer_codingmeet.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigationdrawer_codingmeet.screens.HomeScreen
import com.example.navigationdrawer_codingmeet.screens.NotificationScreen
import com.example.navigationdrawer_codingmeet.screens.ProfileScreen
import com.example.navigationdrawer_codingmeet.screens.SettingScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ){
        composable(Screens.Home.route){
            HomeScreen(innerPadding = innerPadding)
        }
        composable(Screens.Profile.route){
            ProfileScreen(innerPadding = innerPadding)
        }
        composable(Screens.Notification.route){
            NotificationScreen(innerPadding = innerPadding)
        }
        composable(Screens.Setting.route){
            SettingScreen(innerPadding = innerPadding)
        }
    }
}