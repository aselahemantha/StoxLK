package com.example.stoxlk.presentation.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IntroScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background Gradient/Image Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1E2838), // Dark Blueish
                            Color(0xFF7597C3) // Light Blueish
                        )
                    )
                )
        ) {
            // Placeholder for the "Chart" image
             Icon(
                 imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                 contentDescription = "Chart",
                 modifier = Modifier
                     .size(200.dp)
                     .align(Alignment.Center)
                     .padding(bottom = 40.dp),
                 tint = Color.White.copy(alpha = 0.5f)
             )
             
             // CSE Tracker Tag
             Surface(
                 modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 60.dp),
                 shape = RoundedCornerShape(50),
                 color = Color.White.copy(alpha = 0.2f)
             ) {
                 Row(
                     modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                      Icon(
                         imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Placeholder icon
                         contentDescription = null,
                         tint = Color.White,
                         modifier = Modifier.size(16.dp)
                     )
                     Spacer(modifier = Modifier.width(8.dp))
                     Text(
                         text = "CSE Tracker",
                         color = Color.White,
                         fontWeight = FontWeight.Bold,
                         style = MaterialTheme.typography.labelMedium
                     )
                 }
             }
        }

        // Bottom Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 370.dp), // Check overlap
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
             Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = Color(0xFFF8F9FB) // Light gray background
            ) {
                 Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Invest Smarter in",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Sri Lanka",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0056D2) // Blue Color
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        text = "Real-time data from the Colombo Stock Exchange directly to your pocket. Track your portfolio and analyze trends.",
                        textAlign = TextAlign.Center,
                        color = Color.Gray,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // Email Input
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Email Address",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            placeholder = { Text("Enter your email", color = Color.Gray) },
                            modifier = Modifier.fillMaxWidth(),
                            leadingIcon = {
                                Icon(Icons.Default.Email, contentDescription = null, tint = Color(0xFF5A6981))
                            },
                             shape = RoundedCornerShape(12.dp),
                             singleLine = true
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Login Button
                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0056D2)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Log in with Email",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Divider(modifier = Modifier.weight(1f), color = Color.LightGray)
                        Text(
                            text = "or",
                            modifier = Modifier.padding(horizontal = 16.dp),
                            color = Color.Gray,
                             fontSize = 14.sp
                        )
                        Divider(modifier = Modifier.weight(1f), color = Color.LightGray)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Guest Button
                    OutlinedButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                         colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                    ) {
                        Text(
                            text = "Continue as Guest",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    
                    Spacer(modifier = Modifier.weight(1f))
                    
                    Text(
                        text = "By continuing, you agree to our Terms of Service & Privacy Policy.",
                        textAlign = TextAlign.Center,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen()
}
