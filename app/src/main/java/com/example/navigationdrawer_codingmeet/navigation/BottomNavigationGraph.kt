package com.example.navigationdrawer_codingmeet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigationdrawer_codingmeet.screens.bottom_navigation.BottomHomeScreen
import com.example.navigationdrawer_codingmeet.screens.bottom_navigation.BottomNotificationScreen
import com.example.navigationdrawer_codingmeet.screens.bottom_navigation.BottomProfileScreen
import com.example.navigationdrawer_codingmeet.screens.bottom_navigation.BottomSettingScreen


@Composable
fun BottomNavigationGraph(
    rootNavController: NavHostController,
    bottomNavController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = bottomNavController,
        route = Graph.BOTTOM_NAVIGATION_GRAPH,
        startDestination = BottomNavGraph.Home.route
    ) {
        composable(route = BottomNavGraph.Home.route) {
            BottomHomeScreen(modifier = modifier)
        }
        composable(route = BottomNavGraph.Profile.route) {
            BottomProfileScreen(modifier = modifier)
        }
        composable(route = BottomNavGraph.Notification.route) {
            BottomNotificationScreen(
                modifier = modifier,
                onClickNotificationDetail = {
//                    rootNavController.navigate(Graph.NOTIFICATION_GRAPH)
                }
            )
        }
        composable(route = BottomNavGraph.Setting.route) {
            BottomSettingScreen(
                modifier = modifier,
                onClickSettingDetail = {
//                    rootNavController.navigate(Graph.SETTING_GRAPH)
                }
            )
        }
    }
}
sealed class BottomNavGraph(var route: String) {
    data object Home : BottomNavGraph("bottom_home")
    data object Profile : BottomNavGraph("bottom_profile")
    data object Notification : BottomNavGraph("bottom_notification")
    data object Setting : BottomNavGraph("bottom_setting")
}