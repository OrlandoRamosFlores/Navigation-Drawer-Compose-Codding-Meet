package com.example.navigationdrawer_codingmeet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer_codingmeet.navigation.NavigationDrawerBody
import com.example.navigationdrawer_codingmeet.navigation.NavigationDrawerHeader
import com.example.navigationdrawer_codingmeet.navigation.SetUpNavGraph
import com.example.navigationdrawer_codingmeet.navigation.drawerNavigationDestinations
import com.example.navigationdrawer_codingmeet.navigation.navigateSingleTopTo
import com.example.navigationdrawer_codingmeet.screens.TopBarBody
import com.example.navigationdrawer_codingmeet.ui.theme.NavigationDrawer_CodingMeetTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawer_CodingMeetTheme {

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val coroutineScope = rememberCoroutineScope()
                val context = LocalContext.current

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val currentScreen =
                    drawerNavigationDestinations.find { it.route == currentDestination?.route }
                        ?: drawerNavigationDestinations[0]

                ModalNavigationDrawer(
                    gesturesEnabled = drawerState.isOpen,
                    drawerContent = {
                        ModalDrawerSheet {
                            NavigationDrawerHeader()
                            Spacer(modifier = Modifier.height(8.dp))
                            NavigationDrawerBody(
                                items = drawerNavigationDestinations,
                                currentRoute = currentScreen.route,
                                onClick = {
                                    navController.navigateSingleTopTo(it.route)
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
                                currentScreen = currentScreen.title,
                                drawerState = drawerState
                            )
                        }
                    ) { innerPadding ->
                        SetUpNavGraph(
                            navController = navController,
                            modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
