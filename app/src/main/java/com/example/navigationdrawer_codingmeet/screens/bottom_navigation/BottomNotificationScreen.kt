package com.example.navigationdrawer_codingmeet.screens.bottom_navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun BottomNotificationScreen(
    modifier: Modifier = Modifier,
    onClickNotificationDetail: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bottom Notification screen",
            fontSize = 40.sp,
            color = Color.Black
        )
        Button(
            onClick = onClickNotificationDetail
        ) {
            Text(text = "Go to Notification Detail Page", fontSize = 20.sp)
        }
    }
}