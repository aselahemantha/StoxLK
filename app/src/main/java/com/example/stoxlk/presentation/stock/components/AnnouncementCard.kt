package com.example.stoxlk.presentation.stock.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun AnnouncementCard(title: String, date: String, icon: ImageVector = Icons.Default.Campaign) {
    Surface(
        shape = RoundedCornerShape(12f.scaleWidth()),
        border = androidx.compose.foundation.BorderStroke(1f.scaleWidth(), StoxDivider),
        color = StoxCardBg,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16f.scaleWidth())) {
             Box(
                modifier = Modifier
                    .size(40f.scaleWidth())
                    .clip(RoundedCornerShape(8f.scaleWidth()))
                    .background(StoxLightBlue), // Light Blue
                contentAlignment = Alignment.Center
            ) {
                 Icon(icon, contentDescription = null, tint = StoxDarkBlue, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.width(16f.scaleWidth()))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
                Text(
                    "The Board of Directors has declared an interim dividend of LKR 1.50 per share.",
                    fontSize = 12f.scaleFontSize(),
                    color = StoxTextSecondary,
                    maxLines = 2,
                    lineHeight = 16f.scaleFontSize(),
                    modifier = Modifier.padding(vertical = 4f.scaleHeight())
                )
                Text(date, fontSize = 10f.scaleFontSize(), color = StoxTextSecondary)
            }
        }
    }
}
