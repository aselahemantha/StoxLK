package com.example.stoxlk.presentation.search

import com.example.stoxlk.ui.theme.*

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@Composable
fun SearchScreen(onStockClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StoxBackground) // Light Gray Background
            .padding(16f.scaleWidth())
    ) {
        Text(
            text = "Search",
            fontSize = 24f.scaleFontSize(),
            fontWeight = FontWeight.Bold,
            color = StoxTextPrimary
        )
        
        Spacer(modifier = Modifier.height(16f.scaleHeight()))
        
        // Search Bar
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12f.scaleWidth()),
            color = StoxCardBg,
            shadowElevation = 2f.scaleWidth()
        ) {
            Row(
                 modifier = Modifier.padding(horizontal = 16f.scaleWidth(), vertical = 12f.scaleHeight()),
                 verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Search, contentDescription = null, tint = StoxTextSecondary)
                Spacer(modifier = Modifier.width(12f.scaleWidth()))
                // Hardcoded "JK" for visual fidelity to design
                Text("JK", color = StoxTextPrimary, fontSize = 16f.scaleFontSize(), modifier = Modifier.weight(1f))
                Icon(Icons.Default.Cancel, contentDescription = "Clear", tint = StoxTextSecondary) // Using Cancel as Close icon derivative
            }
        }
        
        Spacer(modifier = Modifier.height(24f.scaleHeight()))
        
        // Top Results
        Text(
            text = "Top Results",
            fontSize = 18f.scaleFontSize(),
            fontWeight = FontWeight.Bold,
            color = StoxTextPrimary
        )
        
        Spacer(modifier = Modifier.height(16f.scaleHeight()))
        
        Column(verticalArrangement = Arrangement.spacedBy(12f.scaleHeight())) {
            SearchResultItem(
                code = "JKH.N0000",
                name = "John Keells Holdings", 
                price = "180.00", 
                change = "+1.2%",
                isPositive = true,
                onClick = { onStockClick("JKH.N0000") }
            )
            SearchResultItem(
                code = "JKB.N0000",
                name = "John Keells Hotels...",
                price = "19.50",
                change = "-0.5%",
                isPositive = false,
                onClick = { onStockClick("JKB.N0000") }
            )
             SearchResultItem(
                code = "JKG.N0000",
                name = "John Keells Garm...",
                price = "54.20",
                change = "0.0%",
                isPositive = true, // Neutral, use black/gray logic in item
                onClick = { onStockClick("JKG.N0000") }
            )
        }
        
        Spacer(modifier = Modifier.height(24f.scaleHeight()))
        
        // People also search for
        Text(
            text = "People also search for", 
            fontSize = 18f.scaleFontSize(), 
            fontWeight = FontWeight.Bold, 
            color = StoxTextPrimary
        )
        Spacer(modifier = Modifier.height(12f.scaleHeight()))
        
        // Using a FlowRow-like layout (simple row + column for now as simple FlowRow is experimental/bulky)
        Column(verticalArrangement = Arrangement.spacedBy(8f.scaleHeight())) {
            Row(horizontalArrangement = Arrangement.spacedBy(8f.scaleWidth())) {
                SuggestionChip(text = "DIAL.N0000")
                SuggestionChip(text = "SAMP.N0000")
            }
             Row(horizontalArrangement = Arrangement.spacedBy(8f.scaleWidth())) {
                SuggestionChip(text = "COMB.N0000")
                SuggestionChip(text = "HNB.N0000")
            }
        }
    }
}

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

@Composable
fun SuggestionChip(text: String) {
    Surface(
        shape = RoundedCornerShape(8f.scaleWidth()),
        border = androidx.compose.foundation.BorderStroke(1f.scaleWidth(), Color(0xFFE0E0E0)),
        color = Color.White
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16f.scaleWidth(), vertical = 8f.scaleHeight()),
            fontSize = 14f.scaleFontSize(),
            color = StoxTextSecondary
        )
    }
}
