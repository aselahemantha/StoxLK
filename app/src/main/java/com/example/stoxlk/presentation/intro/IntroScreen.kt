package com.example.stoxlk.presentation.intro

import com.example.stoxlk.ui.theme.*

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun IntroScreen(onLoginClick: () -> Unit) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(StoxCardBg),
    ) {
        // Background Gradient/Image Placeholder
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(400f.scaleHeight())
                    .background(
                        brush =
                            Brush.verticalGradient(
                                colors =
                                    listOf(
                                        StoxSearchBg, // Dark Blueish
                                        StoxChartBlue, // Light Blueish
                                    ),
                            ),
                    ),
        ) {
            // Placeholder for the "Chart" image
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Chart",
                modifier =
                    Modifier
                        .size(200f.scaleWidth())
                        .align(Alignment.Center)
                        .padding(bottom = 40f.scaleHeight()),
                tint = StoxCardBg.copy(alpha = 0.5f),
            )

            // CSE Tracker Tag
            Surface(
                modifier =
                    Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 60f.scaleHeight()),
                shape = RoundedCornerShape(50),
                color = StoxCardBg.copy(alpha = 0.2f),
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16f.scaleWidth(), vertical = 8f.scaleHeight()),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Placeholder icon
                        contentDescription = null,
                        tint = StoxCardBg,
                        modifier = Modifier.size(16f.scaleWidth()),
                    )
                    Spacer(modifier = Modifier.width(8f.scaleWidth()))
                    Text(
                        text = "CSE Tracker",
                        color = StoxCardBg,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }

        // Bottom Content
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(top = 370f.scaleHeight()),
            // Check overlap
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = 32f.scaleWidth(), topEnd = 32f.scaleWidth()),
                color = StoxBackground, // Light gray background
            ) {
                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(24f.scaleWidth()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Invest Smarter in",
                        fontSize = 28f.scaleFontSize(),
                        fontWeight = FontWeight.Bold,
                        color = StoxTextPrimary,
                    )
                    Text(
                        text = "Sri Lanka",
                        fontSize = 28f.scaleFontSize(),
                        fontWeight = FontWeight.Bold,
                        color = StoxPrimaryBlue, // Blue Color
                    )

                    Spacer(modifier = Modifier.height(16f.scaleHeight()))

                    Text(
                        text = "Real-time data from the Colombo Stock Exchange directly to your pocket. Track your portfolio and analyze trends.",
                        textAlign = TextAlign.Center,
                        color = StoxTextSecondary,
                        fontSize = 14f.scaleFontSize(),
                        lineHeight = 20f.scaleFontSize(),
                    )

                    Spacer(modifier = Modifier.height(32f.scaleHeight()))

                    // Email Input
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Email Address",
                            fontWeight = FontWeight.SemiBold,
                            color = StoxTextPrimary,
                            fontSize = 14f.scaleFontSize(),
                        )
                        Spacer(modifier = Modifier.height(8f.scaleHeight()))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            placeholder = { Text("Enter your email", color = StoxTextSecondary) },
                            modifier = Modifier.fillMaxWidth(),
                            leadingIcon = {
                                Icon(Icons.Default.Email, contentDescription = null, tint = StoxTextSecondary)
                            },
                            shape = RoundedCornerShape(12f.scaleWidth()),
                            singleLine = true,
                        )
                    }

                    Spacer(modifier = Modifier.height(24f.scaleHeight()))

                    // Login Button
                    Button(
                        onClick = onLoginClick,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(56f.scaleHeight()),
                        colors = ButtonDefaults.buttonColors(containerColor = StoxPrimaryBlue),
                        shape = RoundedCornerShape(12f.scaleWidth()),
                    ) {
                        Text(
                            text = "Log in with Email",
                            fontSize = 16f.scaleFontSize(),
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(8f.scaleWidth()))
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                    }

                    Spacer(modifier = Modifier.height(24f.scaleHeight()))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Divider(modifier = Modifier.weight(1f), color = Color.LightGray)
                        Text(
                            text = "or",
                            modifier = Modifier.padding(horizontal = 16f.scaleWidth()),
                            color = StoxTextSecondary,
                            fontSize = 14f.scaleFontSize(),
                        )
                        Divider(modifier = Modifier.weight(1f), color = Color.LightGray)
                    }

                    Spacer(modifier = Modifier.height(24f.scaleHeight()))

                    // Guest Button
                    OutlinedButton(
                        onClick = { /* TODO */ },
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(56f.scaleHeight()),
                        shape = RoundedCornerShape(12f.scaleWidth()),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = StoxTextPrimary),
                    ) {
                        Text(
                            text = "Continue as Guest",
                            fontSize = 16f.scaleFontSize(),
                            fontWeight = FontWeight.SemiBold,
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "By continuing, you agree to our Terms of Service & Privacy Policy.",
                        textAlign = TextAlign.Center,
                        color = StoxTextSecondary,
                        fontSize = 12f.scaleFontSize(),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen(onLoginClick = {})
}
