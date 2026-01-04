package com.example.stoxlk.presentation.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12f.scaleWidth()),
        colors = CardDefaults.cardColors(containerColor = StoxCardBg)
    ) {
        Row(
            modifier = Modifier.padding(16f.scaleWidth()),
            verticalAlignment = Alignment.CenterVertically
        ) {
             Box(
                modifier = Modifier
                    .size(64f.scaleWidth())
                    .clip(CircleShape)
                    .background(Color(0xFFFFCC80)) // Placeholder skin tone/color
            ) {
                 Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.align(Alignment.Center).size(32f.scaleWidth()), tint = Color(0xFF5D4037))
                 // In real app use Image(painter = painterResource(id = R.drawable.avatar), ...)
            }
            
            Spacer(modifier = Modifier.width(16f.scaleWidth()))
            
            Column(modifier = Modifier.weight(1f)) {
                Text("John Doe", fontWeight = FontWeight.Bold, fontSize = 18f.scaleFontSize())
                Text("johndoe@example.com", fontSize = 14f.scaleFontSize(), color = StoxTextSecondary)
            }
            
            TextButton(onClick = { /* TODO */ }) {
                Text("Edit", color = StoxPrimaryBlue, fontWeight = FontWeight.Bold)
            }
        }
    }
}
