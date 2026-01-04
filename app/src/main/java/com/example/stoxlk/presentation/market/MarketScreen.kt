package com.example.stoxlk.presentation.market

import com.example.stoxlk.ui.theme.*

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
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth
import com.example.stoxlk.presentation.home.MarketIndexCard

@Composable
fun MarketScreen(onStockClick: (String) -> Unit) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(StoxBackground), // Light Gray Background
    ) {
        // App Bar / Header
        MarketHeader()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16f.scaleHeight()),
            verticalArrangement = Arrangement.spacedBy(24f.scaleHeight()),
        ) {
            // Indices
            item {
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16f.scaleWidth()),
                    horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth()),
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
        color = StoxBackground, // Match background
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16f.scaleWidth()),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "Market Overview",
                    fontSize = 22f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = StoxTextPrimary,
                )
                Text(
                    text = "Last updated: 10:45 AM",
                    fontSize = 12f.scaleFontSize(),
                    color = StoxTextSecondary,
                )
            }
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh", tint = StoxPrimaryBlue)
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
                    .padding(horizontal = 16f.scaleWidth()),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Market Movers", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
            TextButton(onClick = {}) {
                Text("View All", color = StoxPrimaryBlue)
            }
        }

        // Custom Tab Row
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16f.scaleWidth())
                    .background(Color(0xFFE2E8F0), RoundedCornerShape(8f.scaleWidth()))
                    .padding(4f.scaleWidth()),
        ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = selectedTab == index
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(32f.scaleHeight())
                            .clip(RoundedCornerShape(6f.scaleWidth()))
                            .background(if (isSelected) StoxCardBg else Color.Transparent),
                    // .clickable { selectedTab = index } // Add click later if needed
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = title,
                        fontSize = 12f.scaleFontSize(),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) StoxTextPrimary else StoxTextSecondary,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16f.scaleHeight()))

        // Horizontal Movers List
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16f.scaleWidth()),
            horizontalArrangement = Arrangement.spacedBy(12f.scaleWidth()),
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
                .width(140f.scaleWidth())
                .height(130f.scaleHeight()),
        shape = RoundedCornerShape(12f.scaleWidth()),
        colors = CardDefaults.cardColors(containerColor = StoxCardBg),
        onClick = onClick,
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(12f.scaleWidth()),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier =
                        Modifier
                            .size(32f.scaleWidth())
                            .clip(CircleShape)
                            .background(StoxLightBlue),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("J", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = StoxDarkBlue)
                }
                Spacer(modifier = Modifier.width(8f.scaleWidth()))
                Column {
                    Text("JKH.N", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                    Text("John Keells", fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
                }
            }

            Column {
                Text("150.00", fontWeight = FontWeight.Bold, fontSize = 20f.scaleFontSize())
                Text("+2.5%", color = StoxGreen, fontSize = 14f.scaleFontSize(), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
    fun SectorOverviewSection() {
        Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
        Text("Sector Overview", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16f.scaleHeight()))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12f.scaleWidth()),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Column(modifier = Modifier.padding(16f.scaleWidth())) {
                SectorItem("Banking & Finance", "+1.4%", StoxGreen, 0.7f)
                Spacer(modifier = Modifier.height(16f.scaleHeight()))
                SectorItem("Manufacturing", "-0.8%", StoxRed, 0.4f)
                Spacer(modifier = Modifier.height(16f.scaleHeight()))
                SectorItem("Telecommunication", "+0.5%", StoxGreen, 0.5f)
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
            Text(name, fontSize = 14f.scaleFontSize(), color = Color(0xFF424242))
            Text(change, fontSize = 14f.scaleFontSize(), fontWeight = FontWeight.Bold, color = color)
        }
        Spacer(modifier = Modifier.height(8f.scaleHeight()))
        // Custom Progress Bar
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(6f.scaleHeight())
                    .clip(RoundedCornerShape(3f.scaleWidth()))
                    .background(StoxDivider),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth(progress)
                        .height(6f.scaleHeight())
                        .clip(RoundedCornerShape(3f.scaleWidth()))
                        .background(color),
            )
        }
    }
}

@Composable
    fun SharePricesSection(onStockClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
        Text("Today's Share Prices", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12f.scaleHeight()))

        // Filter Chip
        Surface(
            shape = RoundedCornerShape(20f.scaleWidth()),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color.LightGray),
            color = StoxCardBg,
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12f.scaleWidth(), vertical = 8f.scaleHeight()),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(Icons.Default.FilterList, contentDescription = null, modifier = Modifier.size(16f.scaleWidth()))
                Spacer(modifier = Modifier.width(8f.scaleWidth()))
                Text("All Sectors", fontSize = 14f.scaleFontSize())
                Spacer(modifier = Modifier.width(4f.scaleWidth()))
                Icon(Icons.Default.ArrowDropDown, contentDescription = null, modifier = Modifier.size(20f.scaleWidth()))
            }
        }

        Spacer(modifier = Modifier.height(16f.scaleHeight()))

        // Header Row
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("COMPANY", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary, fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f))
            Text("PRICE", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text(
                "VOL",
                fontSize = 12f.scaleFontSize(),
                color = StoxTextSecondary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.5f),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
            )
        }

        Spacer(modifier = Modifier.height(8f.scaleHeight()))

        // List
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12f.scaleWidth()),
            colors = CardDefaults.cardColors(containerColor = StoxCardBg),
        ) {
            Column {
                SharePriceItem("HNB.N0000", "Hatton National Bank", "180.50", "+1.2%", "1.2M", onClick = { onStockClick("HNB.N0000") })
                Divider(color = StoxDivider)
                SharePriceItem("LLUB.N0000", "Chevron Lubricants", "85.00", "-0.5%", "540K", onClick = { onStockClick("LLUB.N0000") })
                Divider(color = StoxDivider)
                SharePriceItem("HAYL.N0000", "Hayleys PLC", "92.30", "0.0%", "890K", onClick = { onStockClick("HAYL.N0000") })
                Divider(color = StoxDivider)
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
                .padding(16f.scaleWidth()),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(2f)) {
            Text(code, fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
            Text(name, fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(price, fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
            Text(
                change,
                fontSize = 12f.scaleFontSize(),
                color =
                    if (change.contains("+")) {
                        StoxGreen
                    } else if (change.contains("-")) {
                        StoxRed
                    } else {
                        StoxTextSecondary
                    },
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            vol,
            fontSize = 14f.scaleFontSize(),
            color = StoxTextPrimary,
            modifier = Modifier.weight(0.5f),
            textAlign = androidx.compose.ui.text.style.TextAlign.End,
        )
    }
}
