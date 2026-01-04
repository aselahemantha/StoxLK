package com.example.stoxlk.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Float.scaleHeight(
    referenceHeight: Float = 932f,
    targetHeight: Float = getCurrentScreenHeight(),
): Dp {
    val scaleFactor = targetHeight / referenceHeight
    return (this * scaleFactor).dp
}
