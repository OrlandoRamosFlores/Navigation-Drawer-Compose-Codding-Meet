package com.example.navigationdrawer_codingmeet.screens.navigation_drawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer_codingmeet.navigation.BottomNavigationGraph
import com.example.navigationdrawer_codingmeet.navigation.NavigationDrawerBody
import com.example.navigationdrawer_codingmeet.navigation.NavigationDrawerHeader
import com.example.navigationdrawer_codingmeet.navigation.NavDrawerNavGraph
import com.example.navigationdrawer_codingmeet.navigation.bottomNavigationDestinations
import com.example.navigationdrawer_codingmeet.navigation.drawerNavigationDestinations
import com.example.navigationdrawer_codingmeet.navigation.navigateSingleTopTo
import com.example.navigationdrawer_codingmeet.screens.TopBarBody
import com.example.navigationdrawer_codingmeet.screens.bottom_navigation.BottomNavigationBar
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawerScreen(
    rootNavController: NavHostController,
    navDrawerNavController: NavHostController = rememberNavController(),
    bottomNavController: NavHostController = rememberNavController()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    //Setting for Navigation Drawer
    val drawerNavBackStackEntry by navDrawerNavController.currentBackStackEntryAsState()
    val drawerCurrentDestination = drawerNavBackStackEntry?.destination
    val drawerCurrentScreen =
        drawerNavigationDestinations.find { it.route == drawerCurrentDestination?.route }
            ?: drawerNavigationDestinations[0]

    // Setting for Bottom Navigation
    val bottomNavBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val bottomCurrentDestination = bottomNavBackStackEntry?.destination
    val bottomCurrentScreen =
        bottomNavigationDestinations.find { it.route == bottomCurrentDestination?.route }
            ?: bottomNavigationDestinations[0]


    ModalNavigationDrawer(
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerHeader()
                Spacer(modifier = Modifier.height(8.dp))
                NavigationDrawerBody(
                    items = drawerNavigationDestinations,
                    currentRoute = drawerCurrentScreen.route,
                    onClick = {
                        navDrawerNavController.navigateSingleTopTo(it.route)
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    }
                )
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopBarBody(
                    currentScreen = drawerCurrentScreen.title,
                    drawerState = drawerState
                )
            },
            bottomBar = {
                if (drawerCurrentScreen.route == drawerNavigationDestinations[1].route) {
                    BottomNavigationBar(
                        items = bottomNavigationDestinations,
                        currentRoute = bottomCurrentScreen.route,
                        onClickItem = {
                            bottomNavController.navigateSingleTopTo(it.route)
                        }
                    )
                }
            }
        ) { innerPadding ->
            NavDrawerNavGraph(
                rootNavController = rootNavController,
                navDrawerNavController = navDrawerNavController,
                modifier = Modifier.padding(innerPadding)
            )
            if (drawerCurrentScreen.route == drawerNavigationDestinations[1].route) {
                BottomNavigationGraph(
                    rootNavController = rootNavController,
                    bottomNavController = bottomNavController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}