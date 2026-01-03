package com.example.stoxlk.presentation.home

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
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.PieChart, contentDescription = "Portfolio") },
                    label = { Text("Portfolio") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.BarChart, contentDescription = "Market") },
                    label = { Text("Market") },
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    label = { Text("Search") },
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = selectedTab == 4,
                    onClick = { selectedTab = 4 },
                )
            }
        },
    ) { paddingValues ->
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFF0F2F5)), // Light Gray Background
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
        contentPadding = PaddingValues(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
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
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray), // Placeholder
                    ) {
                        // Image would go here
                        Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.align(Alignment.Center))
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Good Morning,", fontSize = 12.sp, color = Color.Gray)
                        Text("Navin Perera", fontSize = 16.sp, fontWeight = FontWeight.Bold)
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
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF4CAF50)),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "MARKET OPEN • CLOSES 14:30",
                        color = Color(0xFF2E7D32),
                        fontSize = 12.sp,
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
                        .height(180.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0056D2)),
            ) {
                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text("Total Equity", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
                            Icon(Icons.Default.Visibility, contentDescription = null, tint = Color.White.copy(alpha = 0.8f))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "LKR 1,250,400.00",
                            color = Color.White,
                            fontSize = 28.sp,
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
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                                Icon(
                                    Icons.Default.TrendingUp,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp),
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("+LKR 12,500 (1.2%)", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                            }
                        }
                        Text("Today's Gain", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
                    }
                }
            }
        }

        // Search Bar
        item {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = Color.White,
                shadowElevation = 2.dp,
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Search stocks (e.g. JKH.N0000)", color = Color.Gray)
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
                Text("Market Indices", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                TextButton(onClick = {}) {
                    Text("View All", color = Color(0xFF0056D2))
                }
            }
        }

        // Market Indices Cards
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
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
            Text("Market Movers", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
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
        contentPadding = PaddingValues(16.dp),
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
                    Box(modifier = Modifier.size(48.dp).clip(CircleShape).shimmerEffect())
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Box(
                            modifier =
                                Modifier
                                    .width(100.dp)
                                    .height(12.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier =
                                Modifier
                                    .width(150.dp)
                                    .height(16.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                        )
                    }
                }
                Box(modifier = Modifier.size(24.dp).clip(CircleShape).shimmerEffect())
            }
        }

        // Status Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .width(200.dp)
                        .height(24.dp)
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
                        .height(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .shimmerEffect(),
            )
        }

        // Search Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(8.dp))
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
                            .width(120.dp)
                            .height(20.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .shimmerEffect(),
                )
                Box(
                    modifier =
                        Modifier
                            .width(60.dp)
                            .height(20.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .shimmerEffect(),
                )
            }
        }

        // Indices Cards Shimmer
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(100.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .shimmerEffect(),
                )
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(100.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .shimmerEffect(),
                )
            }
        }

        // Movers Header Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .width(120.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .shimmerEffect(),
            )
        }

        items(3) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(72.dp)
                        .clip(RoundedCornerShape(12.dp))
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
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            // Placeholder for graph
            Icon(Icons.Default.ShowChart, contentDescription = null, tint = if (isPositive) Color(0xFF4CAF50) else Color(0xFFF44336))
            Spacer(modifier = Modifier.height(8.dp))
            Text(value, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(change, fontSize = 12.sp, color = if (isPositive) Color(0xFF4CAF50) else Color(0xFFF44336))
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
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFE3F2FD)),
                contentAlignment = Alignment.Center,
            ) {
                Text("JKH", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text("John Keells Holdings", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text("JKH.N0000", fontSize = 12.sp, color = Color.Gray)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("192.50", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Surface(
                    color = Color(0xFFE8F5E9),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(
                        "+1.25%",
                        color = Color(0xFF2E7D32),
                        fontSize = 10.sp,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp),
                    )
                }
            }
        }
    }
}
