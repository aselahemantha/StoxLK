package com.example.stoxlk.presentation.search.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

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
