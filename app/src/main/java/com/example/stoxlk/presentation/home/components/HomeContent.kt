package com.example.stoxlk.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun HomeContent(onStockClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 16f.scaleWidth(), end = 16f.scaleWidth(), bottom = 16f.scaleHeight()),
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
