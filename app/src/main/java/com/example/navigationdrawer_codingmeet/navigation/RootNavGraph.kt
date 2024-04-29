package com.example.navigationdrawer_codingmeet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer_codingmeet.screens.navigation_drawer.NavigationDrawerScreen

@Composable
fun RootNavGraph(
) {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        route = Graph.ROOT_GRAPH,
        startDestination = Graph.NAVIGATION_DRAWER_GRAPH
    ){
        composable(route = Graph.NAVIGATION_DRAWER_GRAPH){
            NavigationDrawerScreen(rootNavController = rootNavController)
        }
    }
}

object Graph {
    const val ROOT_GRAPH = "root_graph"
    const val NAVIGATION_DRAWER_GRAPH = "auth_graph"
    const val BOTTOM_NAVIGATION_GRAPH = "main_graph"

}