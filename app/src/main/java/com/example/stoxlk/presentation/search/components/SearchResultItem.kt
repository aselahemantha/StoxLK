package com.example.stoxlk.presentation.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleWidth

@Composable
fun SearchResultItem(
    code: String, 
    name: String, 
    price: String, 
    change: String, 
    isPositive: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12f.scaleWidth()),
        colors = CardDefaults.cardColors(containerColor = StoxCardBg),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16f.scaleWidth()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48f.scaleWidth())
                    .clip(RoundedCornerShape(8f.scaleWidth()))
                    .background(StoxSearchBg) // Dark Greenish Blue from design
            )
            
            Spacer(modifier = Modifier.width(16f.scaleWidth()))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(code, fontWeight = FontWeight.Bold, fontSize = 16f.scaleFontSize())
                Text(name, fontSize = 14f.scaleFontSize(), color = StoxTextSecondary, maxLines = 1)
            }
            
            Column(horizontalAlignment = Alignment.End) {
                 Text(
                     change, 
                     color = if (change.contains("+")) StoxGreen else if (change.contains("-")) StoxRed else StoxTextSecondary,
                     fontWeight = FontWeight.Bold,
                     fontSize = 14f.scaleFontSize()
                 )
                Text("LKR $price", fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
            }
            
            Spacer(modifier = Modifier.width(16f.scaleWidth()))
            
            // Add Button
             Box(
                modifier = Modifier
                    .size(36f.scaleWidth())
                    .clip(CircleShape)
                    .background(StoxLightBlue),
                contentAlignment = Alignment.Center
            ) {
                 Icon(Icons.Default.Add, contentDescription = "Add", tint = StoxPrimaryBlue)
             }
        }
    }
}
