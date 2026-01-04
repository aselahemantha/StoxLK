package com.example.stoxlk.presentation.market

import com.example.stoxlk.ui.theme.*

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.stoxlk.presentation.home.components.MarketIndexCard
import com.example.stoxlk.presentation.market.components.MarketHeader
import com.example.stoxlk.presentation.market.components.MarketMoversSection
import com.example.stoxlk.presentation.market.components.SectorOverviewSection
import com.example.stoxlk.presentation.market.components.SharePricesSection

@Composable
fun MarketScreen(onStockClick: (String) -> Unit) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(StoxBackground), // Light Gray Background
    ) {
        // App Bar / Header
        MarketHeader()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16f.scaleHeight()),
            verticalArrangement = Arrangement.spacedBy(24f.scaleHeight()),
        ) {
            // Indices
            item {
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16f.scaleWidth()),
                    horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth()),
                ) {
                    MarketIndexCard(
                        modifier = Modifier.weight(1f),
                        title = "ASPI",
                        value = "10,450.23",
                        change = "+124.50 (+1.2%)",
                        isPositive = true,
                    )
                    MarketIndexCard(
                        modifier = Modifier.weight(1f),
                        title = "S&P SL20",
                        value = "3,012.45",
                        change = "+24.10 (+0.8%)",
                        isPositive = true,
                    )
                }
            }

            // Market Movers
            item {
                MarketMoversSection(onStockClick)
            }

            // Sector Overview
            item {
                SectorOverviewSection()
            }

            // Share Prices
            item {
                SharePricesSection(onStockClick)
            }
        }
    }
}

