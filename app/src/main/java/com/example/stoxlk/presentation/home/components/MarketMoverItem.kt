package com.example.stoxlk.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun MarketMoverItem(onClick: () -> Unit) {
    Surface(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
        shape = RoundedCornerShape(12f.scaleWidth()),
        color = StoxCardBg,
    ) {
        Row(
            modifier = Modifier.padding(12f.scaleWidth()),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(40f.scaleWidth())
                        .clip(RoundedCornerShape(8f.scaleWidth()))
                        .background(StoxLightBlue),
                contentAlignment = Alignment.Center,
            ) {
                Text("JKH", fontSize = 10f.scaleFontSize(), fontWeight = FontWeight.Bold, color = StoxDarkBlue)
            }
            Spacer(modifier = Modifier.width(12f.scaleWidth()))
            Column(modifier = Modifier.weight(1f)) {
                Text("John Keells Holdings", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                Text("JKH.N0000", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("192.50", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                Surface(
                    color = StoxLightGreen,
                    shape = RoundedCornerShape(4f.scaleWidth()),
                ) {
                    Text(
                        "+1.25%",
                        color = StoxDarkGreen,
                        fontSize = 10f.scaleFontSize(),
                        modifier = Modifier.padding(horizontal = 4f.scaleWidth(), vertical = 2f.scaleHeight()),
                    )
                }
            }
        }
    }
}
