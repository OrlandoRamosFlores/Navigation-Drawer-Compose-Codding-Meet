package com.example.navigationdrawer_codingmeet.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.ui.graphics.vector.ImageVector

interface DrawerNavigationDestination {
    val title: String
    val route: String
    val selectedIcon: ImageVector
    val unselectedIcon: ImageVector
    val badgeCount: Int?
}

object Home : DrawerNavigationDestination {
    override val title: String = "Home"
    override val route: String = Screens.Home.route
    override val selectedIcon: ImageVector = Icons.Filled.Home
    override val unselectedIcon: ImageVector = Icons.Outlined.Home
    override val badgeCount: Int? = null
}

object Profile : DrawerNavigationDestination {
    override val title: String = "Profile"
    override val route: String = Screens.Profile.route
    override val selectedIcon: ImageVector = Icons.Filled.Person
    override val unselectedIcon: ImageVector = Icons.Outlined.Person
    override val badgeCount: Int? = null
}

object Notification : DrawerNavigationDestination {
    override val title: String = "Notification"
    override val route: String = Screens.Notification.route
    override val selectedIcon: ImageVector = Icons.Filled.Notifications
    override val unselectedIcon: ImageVector = Icons.Outlined.Notifications
    override val badgeCount: Int = 9
}

object Setting : DrawerNavigationDestination {
    override val title: String = "Setting"
    override val route: String = Screens.Setting.route
    override val selectedIcon: ImageVector = Icons.Filled.Settings
    override val unselectedIcon: ImageVector = Icons.Outlined.Settings
    override val badgeCount: Int? = null
}

object Share : DrawerNavigationDestination {
    override val title: String = "Share"
    override val route: String = Screens.Share.route
    override val selectedIcon: ImageVector = Icons.Filled.Share
    override val unselectedIcon: ImageVector = Icons.Outlined.Share
    override val badgeCount: Int? = null
}

val drawerNavigationDestinations = listOf(Home, Profile, Notification, Setting, Share)
