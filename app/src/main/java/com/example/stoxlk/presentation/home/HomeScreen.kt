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

@Composable
fun HomeContent(onStockClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16f.scaleHeight()),
        verticalArrangement = Arrangement.spacedBy(16f.scaleHeight()),
    ) {
        // Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Avatar
                    Box(
                        modifier =
                            Modifier
                                .size(48f.scaleWidth())
                                .clip(CircleShape)
                                .size(48f.scaleWidth())
                                .clip(CircleShape)
                                .background(Color.LightGray), // Placeholder
                    ) {
                        // Image would go here
                        Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.align(Alignment.Center))
                    }
                    Spacer(modifier = Modifier.width(12f.scaleWidth()))
                    Column {
                        Text("Good Morning,", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
                        Text("Navin Perera", fontSize = 16f.scaleFontSize(), fontWeight = FontWeight.Bold)
                    }
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                }
            }
        }

        // Market Status
        item {
            Surface(
                color = Color(0xFFE8F5E9),
                shape = RoundedCornerShape(50),
                modifier = Modifier.wrapContentSize(),
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12f.scaleWidth(), vertical = 6f.scaleHeight()),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .size(8f.scaleWidth())
                                .clip(CircleShape)
                                .background(StoxGreen),
                    )
                    Spacer(modifier = Modifier.width(8f.scaleWidth()))
                    Text(
                        "MARKET OPEN • CLOSES 14:30",
                        color = StoxDarkGreen,
                        fontSize = 12f.scaleFontSize(),
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }

        // Main Card
        item {
            Card(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(180f.scaleHeight()),
                shape = RoundedCornerShape(16f.scaleWidth()),
                colors = CardDefaults.cardColors(containerColor = StoxPrimaryBlue),
            ) {
                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(20f.scaleWidth()),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text("Total Equity", color = Color.White.copy(alpha = 0.8f), fontSize = 14f.scaleFontSize())
                            Icon(Icons.Default.Visibility, contentDescription = null, tint = Color.White.copy(alpha = 0.8f))
                        }
                        Spacer(modifier = Modifier.height(8f.scaleHeight()))
                        Text(
                            "LKR 1,250,400.00",
                            color = Color.White,
                            fontSize = 28f.scaleFontSize(),
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Surface(
                            color = Color.White.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(8f.scaleWidth()),
                        ) {
                            Row(modifier = Modifier.padding(horizontal = 8f.scaleWidth(), vertical = 4f.scaleHeight())) {
                                Icon(
                                    Icons.Default.TrendingUp,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16f.scaleWidth()),
                                )
                                Spacer(modifier = Modifier.width(4f.scaleWidth()))
                                Text("+LKR 12,500 (1.2%)", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12f.scaleFontSize())
                            }
                        }
                        Text("Today's Gain", color = Color.White.copy(alpha = 0.8f), fontSize = 12f.scaleFontSize())
                    }
                }
            }
        }

        // Search Bar
        item {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8f.scaleWidth()),
                color = StoxCardBg,
                shadowElevation = 2f.scaleWidth(),
            ) {
                Row(
                    modifier = Modifier.padding(12f.scaleWidth()),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(Icons.Default.Search, contentDescription = null, tint = StoxTextSecondary)
                    Spacer(modifier = Modifier.width(12f.scaleWidth()))
                    Text("Search stocks (e.g. JKH.N0000)", color = StoxTextSecondary)
                }
            }
        }

        // Market Indices Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Market Indices", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
                TextButton(onClick = {}) {
                    Text("View All", color = StoxPrimaryBlue)
                }
            }
        }

        // Market Indices Cards
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())) {
                MarketIndexCard(
                    modifier = Modifier.weight(1f),
                    title = "ASPI",
                    value = "11,200.45",
                    change = "↓ 54.20 (0.5%)",
                    isPositive = false,
                )
                MarketIndexCard(
                    modifier = Modifier.weight(1f),
                    title = "S&P SL20",
                    value = "3,100.20",
                    change = "↑ 6.10 (0.2%)",
                    isPositive = true,
                )
            }
        }

        // Market Movers Header
        item {
            Text("Market Movers", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8f.scaleHeight()))
        }

        // Market Movers List
        items(3) {
            MarketMoverItem(onClick = { onStockClick("JKH.N0000") })
        }
    }
}

@Composable
fun HomeShimmer() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16f.scaleWidth()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // Header Shimmer
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(48f.scaleWidth()).clip(CircleShape).shimmerEffect())
                    Spacer(modifier = Modifier.width(12f.scaleWidth()))
                    Column {
                        Box(
                            modifier =
                                Modifier
                                    .width(100f.scaleWidth())
                                    .height(12f.scaleHeight())
                                    .clip(RoundedCornerShape(4f.scaleWidth()))
                                    .shimmerEffect(),
                        )
                        Spacer(modifier = Modifier.height(4f.scaleHeight()))
                        Box(
                            modifier =
                                Modifier
                                    .width(150f.scaleWidth())
                                    .height(16f.scaleHeight())
                                    .clip(RoundedCornerShape(4f.scaleWidth()))
                                    .shimmerEffect(),
                        )
                    }
                }
                Box(modifier = Modifier.size(24f.scaleWidth()).clip(CircleShape).shimmerEffect())
            }
        }

        // Status Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .width(200f.scaleWidth())
                        .height(24f.scaleHeight())
                        .clip(RoundedCornerShape(50))
                        .shimmerEffect(),
            )
        }

        // Card Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(180f.scaleHeight())
                        .clip(RoundedCornerShape(16f.scaleWidth()))
                        .shimmerEffect(),
            )
        }

        // Search Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(48f.scaleHeight())
                        .clip(RoundedCornerShape(8f.scaleWidth()))
                        .shimmerEffect(),
            )
        }

        // Indices Header Shimmer
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(
                    modifier =
                        Modifier
                            .width(120f.scaleWidth())
                            .height(20f.scaleHeight())
                            .clip(RoundedCornerShape(4f.scaleWidth()))
                            .shimmerEffect(),
                )
                Box(
                    modifier =
                        Modifier
                            .width(60f.scaleWidth())
                            .height(20f.scaleHeight())
                            .clip(RoundedCornerShape(4f.scaleWidth()))
                            .shimmerEffect(),
                )
            }
        }

        // Indices Cards Shimmer
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())) {
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(100f.scaleHeight())
                            .clip(RoundedCornerShape(12f.scaleWidth()))
                            .shimmerEffect(),
                )
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(100f.scaleHeight())
                            .clip(RoundedCornerShape(12f.scaleWidth()))
                            .shimmerEffect(),
                )
            }
        }

        // Movers Header Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .width(120f.scaleWidth())
                        .height(20f.scaleHeight())
                        .clip(RoundedCornerShape(4f.scaleWidth()))
                        .shimmerEffect(),
            )
        }

        items(3) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(72f.scaleHeight())
                        .clip(RoundedCornerShape(12f.scaleWidth()))
                        .shimmerEffect(),
            )
        }
    }
}

@Composable
fun Modifier.shimmerEffect(): Modifier =
    composed {
        var size by remember { mutableStateOf(androidx.compose.ui.unit.IntSize.Zero) }
        val transition = rememberInfiniteTransition(label = "")
        val startOffsetX by transition.animateFloat(
            initialValue = -2 * size.width.toFloat(),
            targetValue = 2 * size.width.toFloat(),
            animationSpec =
                infiniteRepeatable(
                    animation = tween(1000),
                ),
            label = "",
        )

        background(
            brush =
                Brush.linearGradient(
                    colors =
                        listOf(
                            Color(0xFFE0E0E0),
                            Color(0xFFF5F5F5),
                            Color(0xFFE0E0E0),
                        ),
                    start = Offset(startOffsetX, 0f),
                    end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
                ),
        ).onGloballyPositioned {
            size = it.size
        }
    }

@Composable
fun MarketIndexCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    change: String,
    isPositive: Boolean,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12f.scaleWidth()),
        colors = CardDefaults.cardColors(containerColor = StoxCardBg),
    ) {
        Column(modifier = Modifier.padding(16f.scaleWidth())) {
            Text(title, fontSize = 12f.scaleFontSize(), fontWeight = FontWeight.Bold, color = StoxTextSecondary)
            Spacer(modifier = Modifier.height(8f.scaleHeight()))
            // Placeholder for graph
            Icon(Icons.Default.ShowChart, contentDescription = null, tint = if (isPositive) StoxGreen else StoxRed)
            Spacer(modifier = Modifier.height(8f.scaleHeight()))
            Text(value, fontSize = 20f.scaleFontSize(), fontWeight = FontWeight.Bold)
            Text(change, fontSize = 12f.scaleFontSize(), color = if (isPositive) StoxGreen else StoxRed)
        }
    }
}

@Composable
fun MarketMoverItem(onClick: () -> Unit) {
    Surface(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
        shape = RoundedCornerShape(12f.scaleWidth()),
        color = StoxCardBg,
    ) {
        Row(
            modifier = Modifier.padding(12f.scaleWidth()),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(40f.scaleWidth())
                        .clip(RoundedCornerShape(8f.scaleWidth()))
                        .background(StoxLightBlue),
                contentAlignment = Alignment.Center,
            ) {
                Text("JKH", fontSize = 10f.scaleFontSize(), fontWeight = FontWeight.Bold, color = StoxDarkBlue)
            }
            Spacer(modifier = Modifier.width(12f.scaleWidth()))
            Column(modifier = Modifier.weight(1f)) {
                Text("John Keells Holdings", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                Text("JKH.N0000", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("192.50", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                Surface(
                    color = StoxLightGreen,
                    shape = RoundedCornerShape(4f.scaleWidth()),
                ) {
                    Text(
                        "+1.25%",
                        color = StoxDarkGreen,
                        fontSize = 10f.scaleFontSize(),
                        modifier = Modifier.padding(horizontal = 4f.scaleWidth(), vertical = 2f.scaleHeight()),
                    )
                }
            }
        }
    }
}
