package com.example.navigationdrawer_codingmeet.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface BottomNavigationDestination {
    val title: String
    val route: String
    val selectedIcon: ImageVector
    val unSelectedIcon: ImageVector
    val hasBadgeDot: Boolean
    val badgeCount: Int?
}
object BottomHome : BottomNavigationDestination {
    override val title: String = "Bottom Home"
    override val route: String = BottomNavGraph.Home.route
    override val selectedIcon: ImageVector = Icons.Filled.Home
    override val unSelectedIcon: ImageVector = Icons.Outlined.Home
    override val hasBadgeDot: Boolean = false
    override val badgeCount: Int? = null
}
object BottomProfile : BottomNavigationDestination {
    override val title: String = "Bottom Profile"
    override val route: String = BottomNavGraph.Profile.route
    override val selectedIcon: ImageVector = Icons.Filled.Person
    override val unSelectedIcon: ImageVector = Icons.Outlined.Person
    override val hasBadgeDot: Boolean = false
    override val badgeCount: Int? = null
}
object BottomNotification : BottomNavigationDestination {
    override val title: String = "Bottom Notification"
    override val route: String = BottomNavGraph.Notification.route
    override val selectedIcon: ImageVector = Icons.Filled.Notifications
    override val unSelectedIcon: ImageVector = Icons.Outlined.Notifications
    override val hasBadgeDot: Boolean = false
    override val badgeCount: Int = 9
}

object BottomSetting : BottomNavigationDestination {
    override val title: String = "Bottom Setting"
    override val route: String = BottomNavGraph.Setting.route
    override val selectedIcon: ImageVector = Icons.Filled.Settings
    override val unSelectedIcon: ImageVector = Icons.Outlined.Settings
    override val hasBadgeDot: Boolean = true
    override val badgeCount: Int? = null
}

val bottomNavigationDestinations = listOf(BottomHome, BottomProfile, BottomNotification, BottomSetting)