package com.example.stoxlk.presentation.login

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stoxlk.ui.theme.StoxBackground
import com.example.stoxlk.ui.theme.StoxCardBg
import com.example.stoxlk.ui.theme.StoxGreen
import com.example.stoxlk.ui.theme.StoxPrimaryBlue
import com.example.stoxlk.ui.theme.StoxTextPrimary
import com.example.stoxlk.ui.theme.StoxTextSecondary
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Suppress("ktlint:standard:function-naming")
@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    var email by remember { mutableStateOf("chamara.p@example.com") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(StoxBackground),
    ) {
        // Top Background with Gradient/Graphic
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
                                        Color(0xFF37474F),
                                        Color(0xFFCFD8DC),
                                        StoxBackground,
                                    ),
                            ),
                    ),
        ) {
            // Placeholder for the 3D Chart Graphic
            Box(
                modifier =
                    Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 60f.scaleHeight()),
            ) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color.White.copy(alpha = 0.2f),
                    border =
                        androidx.compose.foundation.BorderStroke(
                            1.dp,
                            Color.White.copy(alpha = 0.3f),
                        ),
                ) {
                    Row(
                        modifier =
                            Modifier.padding(
                                horizontal = 16f.scaleWidth(),
                                vertical = 8f.scaleHeight(),
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ShowChart, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(8f.scaleWidth()))
                        Text(
                            "StoxLK",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16f.scaleFontSize(),
                        )
                    }
                }
            }
        }

        // Content
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .fillMaxSize()
                    .padding(horizontal = 24f.scaleWidth())
                    .systemBarsPadding(), // Fix overlap with system bars
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.height(200f.scaleHeight()))

            Text(
                text = "Welcome back",
                fontSize = 28f.scaleFontSize(),
                fontWeight = FontWeight.Bold,
                color = StoxTextPrimary,
            )

            Spacer(modifier = Modifier.height(8f.scaleHeight()))

            Text(
                text = "Please enter your password to access\nyour portfolio.",
                fontSize = 14f.scaleFontSize(),
                color = StoxTextSecondary,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(32f.scaleHeight()))

            // Email Field
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Email Address",
                    fontSize = 14f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = StoxTextPrimary,
                    modifier = Modifier.padding(bottom = 8f.scaleHeight()),
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12f.scaleWidth()),
                    colors =
                        OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = StoxCardBg,
                            unfocusedContainerColor = StoxCardBg,
                            focusedBorderColor = StoxPrimaryBlue,
                            unfocusedBorderColor = Color(0xFFE0E0E0),
                        ),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = null,
                            tint = StoxTextSecondary.copy(alpha = 0.5f),
                        )
                    },
                    trailingIcon = {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = StoxGreen)
                    },
                    singleLine = true,
                )
            }

            Spacer(modifier = Modifier.height(24f.scaleHeight()))

            // Password Field
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Password",
                    fontSize = 14f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                    color = StoxTextPrimary,
                    modifier = Modifier.padding(bottom = 8f.scaleHeight()),
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12f.scaleWidth()),
                    colors =
                        OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = StoxCardBg,
                            unfocusedContainerColor = StoxCardBg,
                            focusedBorderColor = StoxPrimaryBlue,
                            unfocusedBorderColor = Color(0xFFE0E0E0),
                        ),
                    placeholder = {
                        Text(
                            "Enter your password",
                            color = StoxTextSecondary.copy(alpha = 0.5f),
                        )
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null,
                            tint = StoxTextSecondary.copy(alpha = 0.5f),
                        ) // Use Lock icon or similar
                    },
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = null,
                                tint = StoxTextSecondary.copy(alpha = 0.5f),
                            )
                        }
                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                )
            }

            Spacer(modifier = Modifier.height(16f.scaleHeight()))

            // Forgot Password
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                TextButton(onClick = { /* TODO */ }) {
                    Text("Forgot Password?", color = StoxPrimaryBlue, fontWeight = FontWeight.Bold)
                }
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
                    text = "Login",
                    fontSize = 16f.scaleFontSize(),
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Protected by StoxLK security systems.",
                fontSize = 12f.scaleFontSize(),
                color = StoxTextSecondary.copy(alpha = 0.5f),
                modifier = Modifier.padding(bottom = 24f.scaleHeight()),
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen(onLoginClick = {})
}
