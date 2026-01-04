package com.example.stoxlk.presentation.home.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun HomeShimmer() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16f.scaleWidth()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // Header Shimmer
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(48f.scaleWidth()).clip(CircleShape).shimmerEffect())
                    Spacer(modifier = Modifier.width(12f.scaleWidth()))
                    Column {
                        Box(
                            modifier =
                                Modifier
                                    .width(100f.scaleWidth())
                                    .height(12f.scaleHeight())
                                    .clip(RoundedCornerShape(4f.scaleWidth()))
                                    .shimmerEffect(),
                        )
                        Spacer(modifier = Modifier.height(4f.scaleHeight()))
                        Box(
                            modifier =
                                Modifier
                                    .width(150f.scaleWidth())
                                    .height(16f.scaleHeight())
                                    .clip(RoundedCornerShape(4f.scaleWidth()))
                                    .shimmerEffect(),
                        )
                    }
                }
                Box(modifier = Modifier.size(24f.scaleWidth()).clip(CircleShape).shimmerEffect())
            }
        }

        // Status Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .width(200f.scaleWidth())
                        .height(24f.scaleHeight())
                        .clip(RoundedCornerShape(50))
                        .shimmerEffect(),
            )
        }

        // Card Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(180f.scaleHeight())
                        .clip(RoundedCornerShape(16f.scaleWidth()))
                        .shimmerEffect(),
            )
        }

        // Search Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(48f.scaleHeight())
                        .clip(RoundedCornerShape(8f.scaleWidth()))
                        .shimmerEffect(),
            )
        }

        // Indices Header Shimmer
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(
                    modifier =
                        Modifier
                            .width(120f.scaleWidth())
                            .height(20f.scaleHeight())
                            .clip(RoundedCornerShape(4f.scaleWidth()))
                            .shimmerEffect(),
                )
                Box(
                    modifier =
                        Modifier
                            .width(60f.scaleWidth())
                            .height(20f.scaleHeight())
                            .clip(RoundedCornerShape(4f.scaleWidth()))
                            .shimmerEffect(),
                )
            }
        }

        // Indices Cards Shimmer
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())) {
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(100f.scaleHeight())
                            .clip(RoundedCornerShape(12f.scaleWidth()))
                            .shimmerEffect(),
                )
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .height(100f.scaleHeight())
                            .clip(RoundedCornerShape(12f.scaleWidth()))
                            .shimmerEffect(),
                )
            }
        }

        // Movers Header Shimmer
        item {
            Box(
                modifier =
                    Modifier
                        .width(120f.scaleWidth())
                        .height(20f.scaleHeight())
                        .clip(RoundedCornerShape(4f.scaleWidth()))
                        .shimmerEffect(),
            )
        }

        items(3) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(72f.scaleHeight())
                        .clip(RoundedCornerShape(12f.scaleWidth()))
                        .shimmerEffect(),
            )
        }
    }
}

@Composable
fun Modifier.shimmerEffect(): Modifier =
    composed {
        var size by remember { mutableStateOf(androidx.compose.ui.unit.IntSize.Zero) }
        val transition = rememberInfiniteTransition(label = "")
        val startOffsetX by transition.animateFloat(
            initialValue = -2 * size.width.toFloat(),
            targetValue = 2 * size.width.toFloat(),
            animationSpec =
                infiniteRepeatable(
                    animation = tween(1000),
                ),
            label = "",
        )

        background(
            brush =
                Brush.linearGradient(
                    colors =
                        listOf(
                            Color(0xFFE0E0E0),
                            Color(0xFFF5F5F5),
                            Color(0xFFE0E0E0),
                        ),
                    start = Offset(startOffsetX, 0f),
                    end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
                ),
        ).onGloballyPositioned {
            size = it.size
        }
    }
