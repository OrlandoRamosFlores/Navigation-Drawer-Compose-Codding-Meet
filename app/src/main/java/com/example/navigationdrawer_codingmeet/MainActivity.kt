package com.example.navigationdrawer_codingmeet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer_codingmeet.navigation.NavBarBody
import com.example.navigationdrawer_codingmeet.navigation.NavBarHeader
import com.example.navigationdrawer_codingmeet.navigation.Screens
import com.example.navigationdrawer_codingmeet.navigation.SetUpNavGraph
import com.example.navigationdrawer_codingmeet.navigation.items
import com.example.navigationdrawer_codingmeet.ui.theme.NavigationDrawer_CodingMeetTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawer_CodingMeetTheme {

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                val context = LocalContext.current

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val topBarTitle =
                    if (currentRoute != null) {
                        items[items.indexOfFirst {
                            it.route == currentRoute
                        }].title
                    } else {
                        items[0].title
                    }

                ModalNavigationDrawer(
                    gesturesEnabled = drawerState.isOpen,
                    drawerContent = {
                        ModalDrawerSheet {
                            NavBarHeader()
                            Spacer(modifier = Modifier.height(8.dp))
                            NavBarBody(
                                items = items,
                                currentRoute = currentRoute
                            ) { currentNavigationItem ->
                                if (currentNavigationItem.route == "share") {
                                    Toast.makeText(context, "contact us", Toast.LENGTH_SHORT).show()
                                } else {
                                    navController.navigate(currentNavigationItem.route) {
                                        navController.graph.startDestinationRoute?.let {
                                            popUpTo(it) {
                                                saveState = true
                                            }
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                                scope.launch {
                                    drawerState.close()
                                }
                            }
                        }
                    },
                    drawerState = drawerState
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Text(text = topBarTitle)
                            },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "menu"
                                        )
                                    }
                                }
                            )
                        }
                    ) { innerPadding ->
                        SetUpNavGraph(navController = navController, innerPadding = innerPadding)
                    }
                }
            }
        }
    }
}
