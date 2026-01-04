package com.example.stoxlk.presentation.stock.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun StatsCard(label: String, value: String, modifier: Modifier = Modifier, isHigh: Boolean? = null) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8f.scaleWidth()),
        color = StoxBackground // Very light gray background
    ) {
        Column(modifier = Modifier.padding(16f.scaleWidth())) {
            Text(label, fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
            Spacer(modifier = Modifier.height(4f.scaleHeight()))
            Text(
                value, 
                fontSize = 16f.scaleFontSize(), 
                fontWeight = FontWeight.Bold,
                color = if (isHigh != null) (if (isHigh) StoxGreen else StoxRed) else StoxTextPrimary
            )
        }
    }
}
