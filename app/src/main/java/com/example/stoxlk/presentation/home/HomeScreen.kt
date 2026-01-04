package com.example.stoxlk.presentation.home

import com.example.stoxlk.ui.theme.*

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth
import androidx.lint.kotlin.metadata.Visibility
import com.example.stoxlk.presentation.market.MarketScreen
import com.example.stoxlk.presentation.portfolio.PortfolioScreen
import com.example.stoxlk.presentation.search.SearchScreen
import com.example.stoxlk.presentation.settings.SettingsScreen
import kotlinx.coroutines.delay

import com.example.stoxlk.presentation.home.components.HomeContent
import com.example.stoxlk.presentation.home.components.HomeShimmer

@Composable
fun HomeScreen(onStockClick: (String) -> Unit) {
    var isLoading by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableIntStateOf(0) } // 0: Home, 1: Portfolio, 2: Market, 3: Search, 4: Settings

    LaunchedEffect(Unit) {
        delay(3000) // Simulate data loading
        isLoading = false
    }

    Scaffold(
        containerColor = StoxBackground,
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = StoxPrimaryBlue,
                        selectedTextColor = StoxPrimaryBlue,
                        indicatorColor = StoxLightBlue
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.PieChart, contentDescription = "Portfolio") },
                    label = { Text("Portfolio") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = StoxPrimaryBlue,
                        selectedTextColor = StoxPrimaryBlue,
                        indicatorColor = StoxLightBlue
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.BarChart, contentDescription = "Market") },
                    label = { Text("Market") },
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                     colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = StoxPrimaryBlue,
                        selectedTextColor = StoxPrimaryBlue,
                        indicatorColor = StoxLightBlue
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    label = { Text("Search") },
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                     colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = StoxPrimaryBlue,
                        selectedTextColor = StoxPrimaryBlue,
                        indicatorColor = StoxLightBlue
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = selectedTab == 4,
                    onClick = { selectedTab = 4 },
                     colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = StoxPrimaryBlue,
                        selectedTextColor = StoxPrimaryBlue,
                        indicatorColor = StoxLightBlue
                    )
                )
            }
        },
    ) { paddingValues ->
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
        ) {
            if (isLoading && selectedTab == 0) {
                HomeShimmer()
            } else {
                when (selectedTab) {
                    0 -> HomeContent(onStockClick = onStockClick)
                    1 -> PortfolioScreen(onStockClick = onStockClick)
                    2 -> MarketScreen(onStockClick = onStockClick)
                    3 -> SearchScreen(onStockClick = onStockClick)
                    4 -> SettingsScreen()
                    else -> HomeContent(onStockClick = onStockClick)
                }
            }
        }
    }
}


