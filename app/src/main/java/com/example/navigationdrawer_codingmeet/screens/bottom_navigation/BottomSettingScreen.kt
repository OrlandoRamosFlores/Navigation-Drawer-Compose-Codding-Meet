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
fun BottomSettingScreen(
    modifier: Modifier = Modifier,
    onClickSettingDetail: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bottom Setting screen",
            fontSize = 40.sp,
            color = Color.Black
        )
        Button(
            onClick = onClickSettingDetail
        ) {
            Text(text = "Go to Setting Detail Page", fontSize = 20.sp)
        }
    }
}