package com.example.stoxlk.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun MarketIndexCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    change: String,
    isPositive: Boolean,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12f.scaleWidth()),
        colors = CardDefaults.cardColors(containerColor = StoxCardBg),
    ) {
        Column(modifier = Modifier.padding(16f.scaleWidth())) {
            Text(title, fontSize = 12f.scaleFontSize(), fontWeight = FontWeight.Bold, color = StoxTextSecondary)
            Spacer(modifier = Modifier.height(8f.scaleHeight()))
            // Placeholder for graph
            Icon(Icons.Default.ShowChart, contentDescription = null, tint = if (isPositive) StoxGreen else StoxRed)
            Spacer(modifier = Modifier.height(8f.scaleHeight()))
            Text(value, fontSize = 20f.scaleFontSize(), fontWeight = FontWeight.Bold)
            Text(change, fontSize = 12f.scaleFontSize(), color = if (isPositive) StoxGreen else StoxRed)
        }
    }
}
