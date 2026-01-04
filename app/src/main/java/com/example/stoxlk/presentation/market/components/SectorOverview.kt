package com.example.stoxlk.presentation.market.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun SectorOverviewSection() {
    Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
        Text("Sector Overview", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16f.scaleHeight()))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12f.scaleWidth()),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Column(modifier = Modifier.padding(16f.scaleWidth())) {
                SectorItem("Banking & Finance", "+1.4%", StoxGreen, 0.7f)
                Spacer(modifier = Modifier.height(16f.scaleHeight()))
                SectorItem("Manufacturing", "-0.8%", StoxRed, 0.4f)
                Spacer(modifier = Modifier.height(16f.scaleHeight()))
                SectorItem("Telecommunication", "+0.5%", StoxGreen, 0.5f)
            }
        }
    }
}

@Composable
fun SectorItem(
    name: String,
    change: String,
    color: Color,
    progress: Float,
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(name, fontSize = 14f.scaleFontSize(), color = Color(0xFF424242))
            Text(change, fontSize = 14f.scaleFontSize(), fontWeight = FontWeight.Bold, color = color)
        }
        Spacer(modifier = Modifier.height(8f.scaleHeight()))
        // Custom Progress Bar
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(6f.scaleHeight())
                    .clip(RoundedCornerShape(3f.scaleWidth()))
                    .background(StoxDivider),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth(progress)
                        .height(6f.scaleHeight())
                        .clip(RoundedCornerShape(3f.scaleWidth()))
                        .background(color),
            )
        }
    }
}
