package com.example.stoxlk.presentation.stock.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

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
