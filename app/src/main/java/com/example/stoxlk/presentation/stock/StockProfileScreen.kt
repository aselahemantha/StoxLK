package com.example.stoxlk.presentation.stock
import com.example.stoxlk.ui.theme.*

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth
import androidx.compose.ui.draw.alpha

@Composable
fun StockProfileScreen(
    symbol: String,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            StockProfileTopBar(symbol, onBackClick)
        },
        containerColor = StoxCardBg
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Price Header
            Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
                Text(
                    text = "LKR 192.50",
                    fontSize = 32f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = StoxTextPrimary
                )
                Spacer(modifier = Modifier.height(4f.scaleHeight()))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.ArrowUpward,
                        contentDescription = null,
                        tint = StoxGreen,
                        modifier = Modifier.size(16f.scaleWidth())
                    )
                    Text(
                        text = " +1.20 (+0.95%)",
                        color = StoxGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14f.scaleFontSize()
                    )
                    Text(
                        text = " Today",
                        color = StoxTextSecondary,
                        fontSize = 14f.scaleFontSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(16f.scaleHeight()))

            // Time Range Tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16f.scaleWidth()),
                horizontalArrangement = Arrangement.spacedBy(8f.scaleWidth())
            ) {
                listOf("1D", "1W", "1M", "3M", "1Y", "ALL").forEach { range ->
                    val isSelected = range == "1M"
                    Surface(
                        shape = RoundedCornerShape(8f.scaleWidth()),
                        color = if (isSelected) StoxCardBg else StoxDivider, // White if selected (logic in design seems subtle) - Design has selected white with shadow maybe? let's stick to simple
                        border = if (isSelected) androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE0E0E0)) else null,
                        shadowElevation = if (isSelected) 2f.scaleWidth() else 0.dp,
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(vertical = 8f.scaleHeight())
                        ) {
                             Text(
                                 text = range, 
                                 fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                 color = if (isSelected) StoxPrimaryBlue else StoxTextSecondary,
                                 fontSize = 12f.scaleFontSize()
                             )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Chart Placeholder (Line Chart)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200f.scaleHeight())
                    .padding(horizontal = 0.dp) // Edge to edge curve
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                StoxLightBlue.copy(alpha = 0.5f),
                                StoxCardBg
                            )
                        )
                    )
            ) {
                // In a real app, use MPAndroidChart or Vico. Here, just a text placeholder or simple canvas.
                // Simulating the blue line with a simple box for now or Icon
                
                 Icon(
                     Icons.Default.ShowChart,
                     contentDescription = "Chart",
                     tint = Color(0xFF2979FF),
                     modifier = Modifier.fillMaxSize().padding(32.dp).alpha(0.2f)
                 )
            }
            
            // X-Axis Labels (Time)
             Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16f.scaleWidth()),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("10:00", fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
                Text("12:00", fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
                Text("14:00", fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
                Text("16:00", fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
            }

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Stats Grid
            Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
                Row(horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())) {
                    StatsCard("Prev Close", "191.30", Modifier.weight(1f))
                    StatsCard("Open", "192.00", Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(16f.scaleHeight()))
                Row(horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())) {
                     StatsCard("Volume", "1.2M", Modifier.weight(1f))
                     StatsCard("Market Cap", "50.4B", Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(16f.scaleHeight()))
                Row(horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())) {
                     StatsCard("High", "194.50", Modifier.weight(1f), true)
                     StatsCard("Low", "191.00", Modifier.weight(1f), false)
                }
            }

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Company Info
            Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Company Info", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
                    Surface(
                         color = StoxLightBlue,
                         shape = RoundedCornerShape(4f.scaleWidth())
                    ) {
                        Text(
                            "Diversified Holdings",
                            fontSize = 11f.scaleFontSize(),
                            color = StoxDarkBlue,
                            modifier = Modifier.padding(horizontal = 6f.scaleWidth(), vertical = 2f.scaleHeight())
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12f.scaleHeight()))
                Surface(
                    shape = RoundedCornerShape(12f.scaleWidth()),
                    border = androidx.compose.foundation.BorderStroke(1f.scaleWidth(), StoxDivider),
                    color = StoxCardBg
                ) {
                    Column(modifier = Modifier.padding(16f.scaleWidth())) {
                        Text(
                            "John Keells Holdings PLC is the largest listed conglomerate on the Colombo Stock Exchange. From managing hotels and resorts in Sri Lanka...",
                            color = StoxTextSecondary,
                            fontSize = 14f.scaleFontSize(),
                            lineHeight = 20f.scaleFontSize()
                        )
                        Spacer(modifier = Modifier.height(8f.scaleHeight()))
                        Text(
                            "Read more",
                            color = StoxChartBlue,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14f.scaleFontSize()
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24f.scaleHeight()))

             // Announcements
              Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
                  Text("Announcements", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
                  Spacer(modifier = Modifier.height(12f.scaleHeight()))
                  AnnouncementCard("Interim Dividend Declaration", "Oct 24, 2023")
                  Spacer(modifier = Modifier.height(12f.scaleHeight()))
                  AnnouncementCard("Quarterly Financial Statements", "Nov 15, 2023", Icons.Default.Description)
                  Spacer(modifier = Modifier.height(24f.scaleHeight()))
              }
        }
    }
}

@Composable
fun StockProfileTopBar(symbol: String, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8f.scaleWidth(), vertical = 8f.scaleHeight()), // Adjust padding for visual alignment
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(symbol, fontWeight = FontWeight.Bold, fontSize = 16f.scaleFontSize())
            Text("JOHN KEELLS HOLDINGS", fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.StarBorder, contentDescription = "Favorite", tint = StoxTextSecondary) // StarOutline doesn't strictly exist in default set sometimes, StarBorder is close
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.Refresh, contentDescription = "Refresh", tint = StoxChartBlue)
        }
    }
}

@Composable
fun StatsCard(label: String, value: String, modifier: Modifier = Modifier, isHigh: Boolean? = null) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8f.scaleWidth()),
        color = StoxBackground // Very light gray background
    ) {
        Column(modifier = Modifier.padding(16f.scaleWidth())) {
            Text(label, fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
            Spacer(modifier = Modifier.height(4f.scaleHeight()))
            Text(
                value, 
                fontSize = 16f.scaleFontSize(), 
                fontWeight = FontWeight.Bold,
                color = if (isHigh != null) (if (isHigh) StoxGreen else StoxRed) else StoxTextPrimary
            )
        }
    }
}

@Composable
fun AnnouncementCard(title: String, date: String, icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Default.Campaign) {
    Surface(
        shape = RoundedCornerShape(12f.scaleWidth()),
        border = androidx.compose.foundation.BorderStroke(1f.scaleWidth(), StoxDivider),
        color = StoxCardBg,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16f.scaleWidth())) {
             Box(
                modifier = Modifier
                    .size(40f.scaleWidth())
                    .clip(RoundedCornerShape(8f.scaleWidth()))
                    .background(StoxLightBlue), // Light Blue
                contentAlignment = Alignment.Center
            ) {
                 Icon(icon, contentDescription = null, tint = StoxDarkBlue, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.width(16f.scaleWidth()))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                Text(
                    "The Board of Directors has declared an interim dividend of LKR 1.50 per share.",
                    fontSize = 12f.scaleFontSize(),
                    color = StoxTextSecondary,
                    maxLines = 2,
                    lineHeight = 16f.scaleFontSize(),
                    modifier = Modifier.padding(vertical = 4f.scaleHeight())
                )
                Text(date, fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
            }
        }
    }
}

