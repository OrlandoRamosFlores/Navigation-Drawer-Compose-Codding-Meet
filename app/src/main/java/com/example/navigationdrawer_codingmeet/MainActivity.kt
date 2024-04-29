package com.example.navigationdrawer_codingmeet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.navigationdrawer_codingmeet.navigation.RootNavGraph
import com.example.navigationdrawer_codingmeet.ui.theme.NavigationDrawer_CodingMeetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawer_CodingMeetTheme {
               RootNavGraph()
            }
        }
    }
}
