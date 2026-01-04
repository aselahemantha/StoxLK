package com.example.stoxlk.presentation.settings.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun SettingsSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column {
        Text(title, fontSize = 12f.scaleFontSize(), fontWeight = FontWeight.Bold, color = StoxTextSecondary, modifier = Modifier.padding(bottom = 8f.scaleHeight(), start = 4f.scaleWidth()))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12f.scaleWidth()),
            colors = CardDefaults.cardColors(containerColor = StoxCardBg)
        ) {
            Column(modifier = Modifier.padding(vertical = 4f.scaleHeight())) {
                content()
            }
        }
    }
}

@Composable
fun SettingsItem(
    icon: ImageVector,
    title: String,
    trailingContent: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16f.scaleWidth(), vertical = 12f.scaleHeight()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = StoxTextSecondary)
        Spacer(modifier = Modifier.width(16f.scaleWidth()))
        Text(title, fontSize = 16f.scaleFontSize(), modifier = Modifier.weight(1f))
        
        if (trailingContent != null) {
            trailingContent()
        } else {
             Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(16f.scaleWidth()))
        }
    }
}
