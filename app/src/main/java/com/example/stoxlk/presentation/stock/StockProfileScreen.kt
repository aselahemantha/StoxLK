package com.example.stoxlk.presentation.stock

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
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Price Header
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "LKR 192.50",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.ArrowUpward,
                        contentDescription = null,
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = " +1.20 (+0.95%)",
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = " Today",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Time Range Tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("1D", "1W", "1M", "3M", "1Y", "ALL").forEach { range ->
                    val isSelected = range == "1M"
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (isSelected) Color.White else Color(0xFFF5F5F5), // White if selected (logic in design seems subtle) - Design has selected white with shadow maybe? let's stick to simple
                        border = if (isSelected) androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE0E0E0)) else null,
                        shadowElevation = if (isSelected) 2.dp else 0.dp,
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                             Text(
                                 text = range, 
                                 fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                 color = if (isSelected) Color(0xFF0056D2) else Color.Gray,
                                 fontSize = 12.sp
                             )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Chart Placeholder (Line Chart)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 0.dp) // Edge to edge curve
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFE3F2FD).copy(alpha = 0.5f),
                                Color.White
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
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("10:00", fontSize = 10.sp, color = Color.Gray)
                Text("12:00", fontSize = 10.sp, color = Color.Gray)
                Text("14:00", fontSize = 10.sp, color = Color.Gray)
                Text("16:00", fontSize = 10.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Stats Grid
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    StatsCard("Prev Close", "191.30", Modifier.weight(1f))
                    StatsCard("Open", "192.00", Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                     StatsCard("Volume", "1.2M", Modifier.weight(1f))
                     StatsCard("Market Cap", "50.4B", Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                     StatsCard("High", "194.50", Modifier.weight(1f), true)
                     StatsCard("Low", "191.00", Modifier.weight(1f), false)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Company Info
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Company Info", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Surface(
                         color = Color(0xFFE3F2FD),
                         shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            "Diversified Holdings",
                            fontSize = 11.sp,
                            color = Color(0xFF1976D2),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFF5F5F5)),
                    color = Color.White
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "John Keells Holdings PLC is the largest listed conglomerate on the Colombo Stock Exchange. From managing hotels and resorts in Sri Lanka...",
                            color = Color.Gray,
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Read more",
                            color = Color(0xFF2979FF),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))

            // Announcements
             Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                 Text("Announcements", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                 Spacer(modifier = Modifier.height(12.dp))
                 AnnouncementCard("Interim Dividend Declaration", "Oct 24, 2023")
                 Spacer(modifier = Modifier.height(12.dp))
                 AnnouncementCard("Quarterly Financial Statements", "Nov 15, 2023", Icons.Default.Description)
                 Spacer(modifier = Modifier.height(24.dp))
             }
        }
    }
}

@Composable
fun StockProfileTopBar(symbol: String, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp), // Adjust padding for visual alignment
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(symbol, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("JOHN KEELLS HOLDINGS", fontSize = 10.sp, color = Color.Gray)
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.StarBorder, contentDescription = "Favorite", tint = Color.Gray) // StarOutline doesn't strictly exist in default set sometimes, StarBorder is close
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.Refresh, contentDescription = "Refresh", tint = Color(0xFF2979FF))
        }
    }
}

@Composable
fun StatsCard(label: String, value: String, modifier: Modifier = Modifier, isHigh: Boolean? = null) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFF8F9FB) // Very light gray background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(label, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                value, 
                fontSize = 16.sp, 
                fontWeight = FontWeight.Bold,
                color = if (isHigh != null) (if (isHigh) Color(0xFF4CAF50) else Color(0xFFF44336)) else Color.Black
            )
        }
    }
}

@Composable
fun AnnouncementCard(title: String, date: String, icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Default.Campaign) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFF5F5F5)),
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
             Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE3F2FD)), // Light Blue
                contentAlignment = Alignment.Center
            ) {
                 Icon(icon, contentDescription = null, tint = Color(0xFF1976D2), modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(
                    "The Board of Directors has declared an interim dividend of LKR 1.50 per share.",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    lineHeight = 16.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(date, fontSize = 10.sp, color = Color.Gray)
            }
        }
    }
}

