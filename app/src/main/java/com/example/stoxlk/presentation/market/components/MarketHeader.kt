package com.example.stoxlk.presentation.market.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleWidth

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
