package com.example.navigationdrawer_codingmeet.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.navigationdrawer_codingmeet.navigation.Screens

@Composable
fun ShareScreen(
    modifier: Modifier
) {
    val context = LocalContext.current
    Toast.makeText(context, "Comparta por este medio", Toast.LENGTH_SHORT).show()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Share screen",
            fontSize = 40.sp,
            color = Color.Black
        )
    }
}