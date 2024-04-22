package com.example.navigationdrawer_codingmeet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
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
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ){
        composable(Screens.Home.route){
            HomeScreen(modifier = modifier)
        }
        composable(Screens.Profile.route){
            ProfileScreen(modifier = modifier)
        }
        composable(Screens.Notification.route){
            NotificationScreen(modifier = modifier)
        }
        composable(Screens.Setting.route){
            SettingScreen(modifier = modifier)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState =true
        }
        launchSingleTop = true
        restoreState = true
    }
sealed class Screens(var route: String) {
    data object Home: Screens("home")
    data object Profile: Screens("profile")
    data object Notification: Screens("notification")
    data object Setting: Screens("setting")
    data object Share: Screens("share")
}