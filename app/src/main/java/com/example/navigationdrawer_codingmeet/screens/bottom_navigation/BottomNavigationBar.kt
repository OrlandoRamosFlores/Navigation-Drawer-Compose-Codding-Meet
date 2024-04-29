package com.example.navigationdrawer_codingmeet.screens.bottom_navigation

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.navigationdrawer_codingmeet.navigation.BottomNavigationDestination


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationDestination>,
    currentRoute: String?,
    onClickItem: (BottomNavigationDestination) -> Unit,
) {
    NavigationBar {
        items.forEach { bottomNavigationItem ->
            NavigationBarItem(
                selected = currentRoute == bottomNavigationItem.route,
                onClick = { onClickItem(bottomNavigationItem) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (bottomNavigationItem.badgeCount != null) {
                                Badge {
                                    Text(text = bottomNavigationItem.badgeCount.toString())
                                }
                            } else if (bottomNavigationItem.hasBadgeDot) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (currentRoute == bottomNavigationItem.route) {
                                bottomNavigationItem.selectedIcon
                            } else {
                                bottomNavigationItem.unSelectedIcon
                            }, contentDescription = bottomNavigationItem.title
                        )
                    }
                },
                label = {
                    Text(text = bottomNavigationItem.title)
                },
                alwaysShowLabel = false
            )
        }
    }
} 