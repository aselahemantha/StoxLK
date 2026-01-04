package com.example.stoxlk.presentation.portfolio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShowChart
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
