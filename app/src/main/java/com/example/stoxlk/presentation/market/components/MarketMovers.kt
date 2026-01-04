package com.example.stoxlk.presentation.market.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

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
