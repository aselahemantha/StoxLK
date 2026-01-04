package com.example.stoxlk.presentation.portfolio.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun PortfolioHeader() {
    Surface(
        color = StoxCardBg,
        shadowElevation = 2f.scaleWidth(),
        shape = RoundedCornerShape(bottomStart = 24f.scaleWidth(), bottomEnd = 24f.scaleWidth())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16f.scaleWidth()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title & Bell
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Portfolio",
                    fontSize = 18f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
                IconButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                }
            }

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Net Worth
            Text("Net Worth", fontSize = 14f.scaleFontSize(), color = StoxPrimaryBlue)
            Spacer(modifier = Modifier.height(4f.scaleHeight()))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    "LKR 1,250,000",
                    fontSize = 32f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    ".00",
                    fontSize = 20f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = StoxTextSecondary,
                    modifier = Modifier.padding(bottom = 4f.scaleHeight())
                )
            }
            
            Spacer(modifier = Modifier.height(12f.scaleHeight()))

            // Gain Pill
            Surface(
                color = StoxLightGreen,
                shape = RoundedCornerShape(50)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12f.scaleWidth(), vertical = 6f.scaleHeight()),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.ShowChart,
                        contentDescription = null,
                        tint = StoxDarkGreen,
                        modifier = Modifier.size(16f.scaleWidth())
                    )
                    Spacer(modifier = Modifier.width(4f.scaleWidth()))
                    Text(
                        "+LKR 25,000 (+2.1%)",
                        color = StoxDarkGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14f.scaleFontSize()
                    )
                    Text(
                        " Today",
                        color = StoxTextSecondary,
                        fontSize = 12f.scaleFontSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16f.scaleWidth())
            ) {
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(48f.scaleHeight()),
                    colors = ButtonDefaults.buttonColors(containerColor = StoxPrimaryBlue),
                    shape = RoundedCornerShape(12f.scaleWidth())
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8f.scaleWidth()))
                    Text("Add Stock")
                }

                OutlinedButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(48f.scaleHeight()),
                    shape = RoundedCornerShape(12f.scaleWidth()),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = StoxTextPrimary)
                ) {
                    Icon(Icons.Default.Remove, contentDescription = null)
                    Spacer(modifier = Modifier.width(8f.scaleWidth()))
                    Text("Remove Stock")
                }
            }
        }
    }
}
