package com.example.stoxlk.presentation.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stoxlk.presentation.home.MarketIndexCard

@Composable
fun PortfolioScreen(onStockClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F2F5)) // Light Gray Background
    ) {
        // App Bar / Header
        PortfolioHeader()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Your Holdings Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Your Holdings", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    TextButton(onClick = {}) {
                        Text("View All", color = Color(0xFF0056D2))
                    }
                }
            }

            // Holdings List
            items(3) {
                HoldingItem(onClick = { onStockClick("JKH.N0000") })
            }
        }
    }
}

@Composable
fun PortfolioHeader() {
    Surface(
        color = Color.White,
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title & Bell
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Portfolio",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
                IconButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Net Worth
            Text("Net Worth", fontSize = 14.sp, color = Color(0xFF0056D2))
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    "LKR 1,250,000",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    ".00",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))

            // Gain Pill
            Surface(
                color = Color(0xFFE8F5E9),
                shape = RoundedCornerShape(50)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.ShowChart,
                        contentDescription = null,
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "+LKR 25,000 (+2.1%)",
                        color = Color(0xFF2E7D32),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        " Today",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0056D2)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Add Stock")
                }

                OutlinedButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                ) {
                    Icon(Icons.Default.Remove, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Remove Stock")
                }
            }
        }
    }
}

@Composable
fun HoldingItem(onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Top Row: Icon, Name/Desc, Total Value, Total Gain
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Stock Icon Placeholder
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF004D40)), // Dark Teal placeholder
                    contentAlignment = Alignment.Center
                ) {
                   // Icon
                   Text("J", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
                
                Spacer(modifier = Modifier.width(12.dp))
                
                // Name & Code
                Column(modifier = Modifier.weight(1f)) {
                    Text("JKH.N0000", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text("John Keells Holdings", fontSize = 12.sp, color = Color.Gray) // Blueish gray text
                }
                
                // Value & Gain
                Column(horizontalAlignment = Alignment.End) {
                    Text("LKR 165,000.00", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text("+10.0%", fontSize = 12.sp, color = Color(0xFF4CAF50), fontWeight = FontWeight.Bold)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color(0xFFF5F5F5))
            Spacer(modifier = Modifier.height(16.dp))
            
            // Stats Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("QTY", fontSize = 10.sp, color = Color(0xFF5A6981), fontWeight = FontWeight.Bold) // Blueish gray
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("1,000", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
                
                Column {
                    Text("AVG COST", fontSize = 10.sp, color = Color(0xFF5A6981), fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("150.00", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
                 Column(horizontalAlignment = Alignment.End) {
                    Text("MKT PRICE", fontSize = 10.sp, color = Color(0xFF5A6981), fontWeight = FontWeight.Bold)
                     Spacer(modifier = Modifier.height(4.dp))
                    Text("165.00", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Day P/L
             Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                 Row {
                      Text("Day P/L: ", fontSize = 12.sp, color = Color(0xFF5A6981))
                      Text("+1,200.00", fontSize = 12.sp, color = Color(0xFF4CAF50), fontWeight = FontWeight.Bold)
                 }
                
                // Mini Chart Icon Placeholder
                Icon(Icons.Default.ShowChart, contentDescription = null, tint = Color(0xFF5A6981))
            }
        }
    }
}
