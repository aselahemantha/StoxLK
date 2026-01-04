package com.example.stoxlk.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun getCurrentScreenWidth(): Float {
    return LocalConfiguration.current.screenWidthDp.toFloat()
}

@Composable
fun getCurrentScreenHeight(): Float {
    return LocalConfiguration.current.screenHeightDp.toFloat()
}
