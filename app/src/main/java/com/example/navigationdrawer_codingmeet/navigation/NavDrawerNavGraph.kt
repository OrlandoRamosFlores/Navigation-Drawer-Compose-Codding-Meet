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
import com.example.navigationdrawer_codingmeet.screens.ShareScreen
import com.example.navigationdrawer_codingmeet.screens.bottom_navigation.BottomHomeScreen

@Composable
fun NavDrawerNavGraph(
    rootNavController: NavHostController,
    navDrawerNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navDrawerNavController,
        route = Graph.NAVIGATION_DRAWER_GRAPH,
        startDestination = Screens.Home.route
    ){
        composable(Screens.Home.route){
            HomeScreen(modifier = modifier)
        }
        composable(Screens.Profile.route){
            BottomHomeScreen(modifier = modifier)
        }
        composable(Screens.Notification.route){
            NotificationScreen(modifier = modifier)
        }
        composable(Screens.Setting.route){
            SettingScreen(modifier = modifier)
        }
        composable(Screens.Share.route){
            ShareScreen(modifier = modifier)
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