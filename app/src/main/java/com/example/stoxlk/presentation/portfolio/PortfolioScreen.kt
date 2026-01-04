package com.example.stoxlk.presentation.portfolio

import com.example.stoxlk.ui.theme.*

// ... inside composables replacing colors:
// Color(0xFFF0F2F5) -> StoxBackground
// Color(0xFF0056D2) -> StoxPrimaryBlue
// Color.White -> StoxCardBg
// Color(0xFFE8F5E9) -> StoxLightGreen
// Color(0xFF4CAF50) -> StoxGreen
// Color(0xFF2E7D32) -> StoxDarkGreen
// Color.Gray -> StoxTextSecondary
// Color.Black -> StoxTextPrimary

import androidx.compose.foundation.background

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
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth
import com.example.stoxlk.presentation.home.MarketIndexCard

@Composable
fun PortfolioScreen(onStockClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StoxBackground) // Light Gray Background
    ) {
        // App Bar / Header
        PortfolioHeader()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16f.scaleWidth()),
            verticalArrangement = Arrangement.spacedBy(16f.scaleHeight())
        ) {
            // Your Holdings Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Your Holdings", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
                    TextButton(onClick = {}) {
                        Text("View All", color = StoxPrimaryBlue)
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
        color = StoxCardBg,
        shadowElevation = 2f.scaleWidth(),
        shape = RoundedCornerShape(bottomStart = 24f.scaleWidth(), bottomEnd = 24f.scaleWidth())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16f.scaleWidth()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title & Bell
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Portfolio",
                    fontSize = 18f.scaleFontSize(),
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

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Net Worth
            Text("Net Worth", fontSize = 14f.scaleFontSize(), color = StoxPrimaryBlue)
            Spacer(modifier = Modifier.height(4f.scaleHeight()))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    "LKR 1,250,000",
                    fontSize = 32f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    ".00",
                    fontSize = 20f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = StoxTextSecondary,
                    modifier = Modifier.padding(bottom = 4f.scaleHeight())
                )
            }
            
            Spacer(modifier = Modifier.height(12f.scaleHeight()))

            // Gain Pill
            Surface(
                color = StoxLightGreen,
                shape = RoundedCornerShape(50)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12f.scaleWidth(), vertical = 6f.scaleHeight()),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.ShowChart,
                        contentDescription = null,
                        tint = StoxDarkGreen,
                        modifier = Modifier.size(16f.scaleWidth())
                    )
                    Spacer(modifier = Modifier.width(4f.scaleWidth()))
                    Text(
                        "+LKR 25,000 (+2.1%)",
                        color = StoxDarkGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14f.scaleFontSize()
                    )
                    Text(
                        " Today",
                        color = StoxTextSecondary,
                        fontSize = 12f.scaleFontSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())
            ) {
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(48f.scaleHeight()),
                    colors = ButtonDefaults.buttonColors(containerColor = StoxPrimaryBlue),
                    shape = RoundedCornerShape(12f.scaleWidth())
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8f.scaleWidth()))
                    Text("Add Stock")
                }

                OutlinedButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(48f.scaleHeight()),
                    shape = RoundedCornerShape(12f.scaleWidth()),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = StoxTextPrimary)
                ) {
                    Icon(Icons.Default.Remove, contentDescription = null)
                    Spacer(modifier = Modifier.width(8f.scaleWidth()))
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
        shape = RoundedCornerShape(16f.scaleWidth()),
        colors = CardDefaults.cardColors(containerColor = StoxCardBg),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(16f.scaleWidth())
        ) {
            // Top Row: Icon, Name/Desc, Total Value, Total Gain
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Stock Icon Placeholder
                Box(
                    modifier = Modifier
                        .size(48f.scaleWidth())
                        .clip(CircleShape)
                        .background(Color(0xFF004D40)), // Dark Teal placeholder
                    contentAlignment = Alignment.Center
                ) {
                   // Icon
                   Text("J", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20f.scaleFontSize())
                }
                
                Spacer(modifier = Modifier.width(12f.scaleWidth()))
                
                // Name & Code
                Column(modifier = Modifier.weight(1f)) {
                    Text("JKH.N0000", fontWeight = FontWeight.Bold, fontSize = 16f.scaleFontSize())
                    Text("John Keells Holdings", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary) // Blueish gray text
                }
                
                // Value & Gain
                Column(horizontalAlignment = Alignment.End) {
                    Text("LKR 165,000.00", fontWeight = FontWeight.Bold, fontSize = 16f.scaleFontSize())
                    Text("+10.0%", fontSize = 12f.scaleFontSize(), color = StoxGreen, fontWeight = FontWeight.Bold)
                }
            }
            
            Spacer(modifier = Modifier.height(16f.scaleHeight()))
            Divider(color = StoxDivider)
            Spacer(modifier = Modifier.height(16f.scaleHeight()))
            
            // Stats Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("QTY", fontSize = 10f.scaleFontSize(), color = Color(0xFF5A6981), fontWeight = FontWeight.Bold) // Blueish gray
                    Spacer(modifier = Modifier.height(4f.scaleHeight()))
                    Text("1,000", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                }
                
                Column {
                    Text("AVG COST", fontSize = 10f.scaleFontSize(), color = Color(0xFF5A6981), fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4f.scaleHeight()))
                    Text("150.00", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                }
                 Column(horizontalAlignment = Alignment.End) {
                    Text("MKT PRICE", fontSize = 10f.scaleFontSize(), color = Color(0xFF5A6981), fontWeight = FontWeight.Bold)
                     Spacer(modifier = Modifier.height(4f.scaleHeight()))
                    Text("165.00", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                }
            }
            
            Spacer(modifier = Modifier.height(16f.scaleHeight()))
            
            // Day P/L
             Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                 Row {
                      Text("Day P/L: ", fontSize = 12f.scaleFontSize(), color = Color(0xFF5A6981))
                      Text("+1,200.00", fontSize = 12f.scaleFontSize(), color = Color(0xFF4CAF50), fontWeight = FontWeight.Bold)
                 }
                
                // Mini Chart Icon Placeholder
                Icon(Icons.Default.ShowChart, contentDescription = null, tint = Color(0xFF5A6981))
            }
        }
    }
}
