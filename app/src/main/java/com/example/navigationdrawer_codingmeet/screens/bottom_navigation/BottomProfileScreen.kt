package com.example.navigationdrawer_codingmeet.screens.bottom_navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pagerPage = remember { mutableIntStateOf(0) }
        val collectionTabs =
            arrayListOf("tab0", "tab1", "tab2", "tab3", "tab4", "tab5", "tab6", "tab7")
        val pagerState = rememberPagerState { collectionTabs.count() }
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(key1 = pagerState.currentPage) {
            pagerPage.intValue = pagerState.currentPage
        }

        ScrollableTabRow(
            edgePadding = 0.dp,
            //SelectedTabIndex must be guarded against real amount changes causing index exceptions
            selectedTabIndex = minOf(collectionTabs.count(), pagerPage.intValue),
            tabs = {
                //Dynamic Tabs from database with +1 shifted index
                collectionTabs.forEachIndexed { index, tabName ->
                    Tab(
                        onClick = {
                            pagerPage.intValue = index
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = { Text(text = tabName) },
                        selected = index == pagerState.currentPage,
                    )
                }
            }
        )
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            beyondBoundsPageCount = collectionTabs.count(),
            state = pagerState,
            userScrollEnabled = true
        ) { tabIndex ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Android ${collectionTabs[tabIndex]}")
            }
        }
    }
}