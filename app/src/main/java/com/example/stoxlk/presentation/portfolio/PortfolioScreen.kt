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
import com.example.stoxlk.presentation.portfolio.components.PortfolioHeader
import com.example.stoxlk.presentation.portfolio.components.HoldingItem

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
            contentPadding = PaddingValues(horizontal = 16f.scaleWidth(), vertical = 16f.scaleHeight()),
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


