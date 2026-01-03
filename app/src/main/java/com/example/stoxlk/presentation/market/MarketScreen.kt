package com.example.stoxlk.presentation.market

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stoxlk.presentation.home.MarketIndexCard

@Composable
fun MarketScreen(onStockClick: (String) -> Unit) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F2F5)), // Light Gray Background
    ) {
        // App Bar / Header
        MarketHeader()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            // Indices
            item {
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    MarketIndexCard(
                        modifier = Modifier.weight(1f),
                        title = "ASPI",
                        value = "10,450.23",
                        change = "+124.50 (+1.2%)",
                        isPositive = true,
                    )
                    MarketIndexCard(
                        modifier = Modifier.weight(1f),
                        title = "S&P SL20",
                        value = "3,012.45",
                        change = "+24.10 (+0.8%)",
                        isPositive = true,
                    )
                }
            }

            // Market Movers
            item {
                MarketMoversSection(onStockClick)
            }

            // Sector Overview
            item {
                SectorOverviewSection()
            }

            // Share Prices
            item {
                SharePricesSection(onStockClick)
            }
        }
    }
}

@Composable
fun MarketHeader() {
    Surface(
        color = Color(0xFFF0F2F5), // Match background
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "Market Overview",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    text = "Last updated: 10:45 AM",
                    fontSize = 12.sp,
                    color = Color.Gray,
                )
            }
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh", tint = Color(0xFF0056D2))
            }
        }
    }
}

@Composable
fun MarketMoversSection(onStockClick: (String) -> Unit) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Gainers", "Losers", "Active")

    Column {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Market Movers", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = {}) {
                Text("View All", color = Color(0xFF0056D2))
            }
        }

        // Custom Tab Row
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color(0xFFE2E8F0), RoundedCornerShape(8.dp))
                    .padding(4.dp),
        ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = selectedTab == index
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (isSelected) Color.White else Color.Transparent),
                    // .clickable { selectedTab = index } // Add click later if needed
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = title,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.Black else Color.Gray,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Horizontal Movers List
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(3) {
                MoverCard(onClick = { onStockClick("JKH.N0000") })
            }
        }
    }
}

@Composable
fun MoverCard(onClick: () -> Unit) {
    Card(
        modifier =
            Modifier
                .width(140.dp)
                .height(130.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onClick,
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier =
                        Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE3F2FD)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("J", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("JKH.N", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("John Keells", fontSize = 10.sp, color = Color.Gray)
                }
            }

            Column {
                Text("150.00", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("+2.5%", color = Color(0xFF4CAF50), fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun SectorOverviewSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text("Sector Overview", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                SectorItem("Banking & Finance", "+1.4%", Color(0xFF4CAF50), 0.7f)
                Spacer(modifier = Modifier.height(16.dp))
                SectorItem("Manufacturing", "-0.8%", Color(0xFFF44336), 0.4f)
                Spacer(modifier = Modifier.height(16.dp))
                SectorItem("Telecommunication", "+0.5%", Color(0xFF4CAF50), 0.5f)
            }
        }
    }
}

@Composable
fun SectorItem(
    name: String,
    change: String,
    color: Color,
    progress: Float,
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(name, fontSize = 14.sp, color = Color(0xFF424242))
            Text(change, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = color)
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Custom Progress Bar
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(Color(0xFFF5F5F5)),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth(progress)
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(color),
            )
        }
    }
}

@Composable
fun SharePricesSection(onStockClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text("Today's Share Prices", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))

        // Filter Chip
        Surface(
            shape = RoundedCornerShape(20.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color.LightGray),
            color = Color.White,
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(Icons.Default.FilterList, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("All Sectors", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Default.ArrowDropDown, contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Header Row
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("COMPANY", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f))
            Text("PRICE", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text(
                "VOL",
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.5f),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // List
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Column {
                SharePriceItem("HNB.N0000", "Hatton National Bank", "180.50", "+1.2%", "1.2M", onClick = { onStockClick("HNB.N0000") })
                Divider(color = Color(0xFFF5F5F5))
                SharePriceItem("LLUB.N0000", "Chevron Lubricants", "85.00", "-0.5%", "540K", onClick = { onStockClick("LLUB.N0000") })
                Divider(color = Color(0xFFF5F5F5))
                SharePriceItem("HAYL.N0000", "Hayleys PLC", "92.30", "0.0%", "890K", onClick = { onStockClick("HAYL.N0000") })
                Divider(color = Color(0xFFF5F5F5))
                SharePriceItem("COMB.N0000", "Commercial Bank", "64.50", "+0.4%", "2.1M", onClick = { onStockClick("COMB.N0000") })
            }
        }
    }
}

@Composable
fun SharePriceItem(
    code: String,
    name: String,
    price: String,
    change: String,
    vol: String,
    onClick: () -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(2f)) {
            Text(code, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(name, fontSize = 12.sp, color = Color.Gray)
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(price, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(
                change,
                fontSize = 12.sp,
                color =
                    if (change.contains("+")) {
                        Color(0xFF4CAF50)
                    } else if (change.contains("-")) {
                        Color(0xFFF44336)
                    } else {
                        Color.Gray
                    },
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            vol,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.weight(0.5f),
            textAlign = androidx.compose.ui.text.style.TextAlign.End,
        )
    }
}
