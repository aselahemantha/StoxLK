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
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth
import com.example.stoxlk.R
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.presentation.settings.components.ProfileCard
import com.example.stoxlk.presentation.settings.components.SettingsSection
import com.example.stoxlk.presentation.settings.components.SettingsItem

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StoxBackground) // Light Gray Background
            .padding(16f.scaleWidth())
    ) {
        Text(
            text = "Settings",
            fontSize = 24f.scaleFontSize(),
            fontWeight = FontWeight.Bold,
            color = StoxTextPrimary
        )
        
        Spacer(modifier = Modifier.height(16f.scaleHeight()))
        
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16f.scaleHeight()),
            verticalArrangement = Arrangement.spacedBy(24f.scaleHeight())
        ) {
            // Profile Card
            item {
                ProfileCard()
            }
            
            // Account Section
            item {
                SettingsSection(title = "ACCOUNT") {
                    SettingsItem(icon = Icons.Default.Person, title = "Edit Profile")
                    Divider(color = StoxDivider)
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
                                Text("LKR (Default)", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
                                Spacer(modifier = Modifier.width(8f.scaleWidth()))
                                Icon(Icons.Default.Lock, contentDescription = "Locked", tint = Color.LightGray, modifier = Modifier.size(16f.scaleWidth()))
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
                    fontSize = 12f.scaleFontSize(),
                    color = StoxTextSecondary,
                    modifier = Modifier.padding(start = 16f.scaleWidth(), top = 8f.scaleHeight())
                )
            }
            
            // Support & Info Section
            item {
                SettingsSection(title = "SUPPORT & INFO") {
                    SettingsItem(icon = Icons.Default.Info, title = "About StoxLK")
                    Divider(color = StoxDivider)
                    SettingsItem(icon = Icons.Default.Warning, title = "Disclaimer") // Using Warning as close approx to Triangle Alert
                    Divider(color = StoxDivider)
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
                            color = StoxRed,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16f.scaleFontSize()
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16f.scaleHeight()))
                    
                    Text("Version 1.0.0 (Build 2023)", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
                     Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Made with ", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
                        Icon(Icons.Default.Favorite, contentDescription = "Love", tint = StoxRed, modifier = Modifier.size(12f.scaleWidth()))
                        Text(" in Sri Lanka", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
                    }
                }
            }
        }
    }
}


