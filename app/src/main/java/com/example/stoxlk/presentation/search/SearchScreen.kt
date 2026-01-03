package com.example.stoxlk.presentation.search

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

@Composable
fun SearchScreen(onStockClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F2F5)) // Light Gray Background
            .padding(16.dp)
    ) {
        Text(
            text = "Search",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Search Bar
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White,
            shadowElevation = 2.dp
        ) {
            Row(
                 modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                 verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
                Spacer(modifier = Modifier.width(12.dp))
                // Hardcoded "JK" for visual fidelity to design
                Text("JK", color = Color.Black, fontSize = 16.sp, modifier = Modifier.weight(1f))
                Icon(Icons.Default.Cancel, contentDescription = "Clear", tint = Color.Gray) // Using Cancel as Close icon derivative
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Top Results
        Text(
            text = "Top Results",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
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
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // People also search for
        Text(
            text = "People also search for", 
            fontSize = 18.sp, 
            fontWeight = FontWeight.Bold, 
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        // Using a FlowRow-like layout (simple row + column for now as simple FlowRow is experimental/bulky)
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SuggestionChip(text = "DIAL.N0000")
                SuggestionChip(text = "SAMP.N0000")
            }
             Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
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
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF264653)) // Dark Greenish Blue from design
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(code, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(name, fontSize = 14.sp, color = Color.Gray, maxLines = 1)
            }
            
            Column(horizontalAlignment = Alignment.End) {
                 Text(
                     change, 
                     color = if (change.contains("+")) Color(0xFF4CAF50) else if (change.contains("-")) Color(0xFFF44336) else Color.Gray,
                     fontWeight = FontWeight.Bold,
                     fontSize = 14.sp
                 )
                Text("LKR $price", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Add Button
             Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE3F2FD)),
                contentAlignment = Alignment.Center
            ) {
                 Icon(Icons.Default.Add, contentDescription = "Add", tint = Color(0xFF0056D2))
             }
        }
    }
}

@Composable
fun SuggestionChip(text: String) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE0E0E0)),
        color = Color.White
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 14.sp,
            color = Color(0xFF424242)
        )
    }
}
