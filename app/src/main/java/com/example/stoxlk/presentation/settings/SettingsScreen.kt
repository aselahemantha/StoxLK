package com.example.stoxlk.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stoxlk.R

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F2F5)) // Light Gray Background
            .padding(16.dp)
    ) {
        Text(
            text = "Settings",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Profile Card
            item {
                ProfileCard()
            }
            
            // Account Section
            item {
                SettingsSection(title = "ACCOUNT") {
                    SettingsItem(icon = Icons.Default.Person, title = "Edit Profile")
                    Divider(color = Color(0xFFF5F5F5))
                    SettingsItem(icon = Icons.Default.Lock, title = "Change Password")
                }
            }
            
            // Preferences Section
            item {
                SettingsSection(title = "PREFERENCES") {
                    SettingsItem(
                        icon = Icons.Default.CurrencyRupee, // Using closest currency icon, realistically Custom or SVG
                        title = "Currency",
                        trailingContent = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("LKR (Default)", fontSize = 12.sp, color = Color.Gray)
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(Icons.Default.Lock, contentDescription = "Locked", tint = Color.LightGray, modifier = Modifier.size(16.dp))
                            }
                        }
                    )
                     Divider(color = Color(0xFFF5F5F5))
                    SettingsItem(
                        icon = Icons.Default.Notifications, 
                        title = "Price Alerts",
                        trailingContent = {
                           Switch(checked = true, onCheckedChange = {})
                        }
                    )
                     Divider(color = Color(0xFFF5F5F5))
                    SettingsItem(
                        icon = Icons.Default.Newspaper, 
                        title = "Market News",
                        trailingContent = {
                           Switch(checked = false, onCheckedChange = {})
                        }
                    )
                }
                 Text(
                    "Daily summary and breaking news alerts for CSE.",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )
            }
            
            // Support & Info Section
            item {
                SettingsSection(title = "SUPPORT & INFO") {
                    SettingsItem(icon = Icons.Default.Info, title = "About StoxLK")
                    Divider(color = Color(0xFFF5F5F5))
                    SettingsItem(icon = Icons.Default.Warning, title = "Disclaimer") // Using Warning as close approx to Triangle Alert
                    Divider(color = Color(0xFFF5F5F5))
                    SettingsItem(icon = Icons.Default.PrivacyTip, title = "Privacy Policy")
                }
            }
            
            // Log Out & Footer
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextButton(onClick = { /* TODO */ }) {
                        Text(
                            "Log Out",
                            color = Color(0xFFF44336),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text("Version 1.0.0 (Build 2023)", fontSize = 12.sp, color = Color.Gray)
                     Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Made with ", fontSize = 12.sp, color = Color.Gray)
                        Icon(Icons.Default.Favorite, contentDescription = "Love", tint = Color(0xFFF44336), modifier = Modifier.size(12.dp))
                        Text(" in Sri Lanka", fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
             Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFCC80)) // Placeholder skin tone/color
            ) {
                 Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.align(Alignment.Center).size(32.dp), tint = Color(0xFF5D4037))
                 // In real app use Image(painter = painterResource(id = R.drawable.avatar), ...)
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text("John Doe", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("johndoe@example.com", fontSize = 14.sp, color = Color.Gray)
            }
            
            TextButton(onClick = { /* TODO */ }) {
                Text("Edit", color = Color(0xFF0056D2), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun SettingsSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column {
        Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(bottom = 8.dp, start = 4.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
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
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color.Gray)
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, fontSize = 16.sp, modifier = Modifier.weight(1f))
        
        if (trailingContent != null) {
            trailingContent()
        } else {
             Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(16.dp))
        }
    }
}
