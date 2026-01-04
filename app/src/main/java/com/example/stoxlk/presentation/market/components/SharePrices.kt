package com.example.stoxlk.presentation.market.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.stoxlk.ui.theme.*
import com.example.stoxlk.util.scaleFontSize
import com.example.stoxlk.util.scaleHeight
import com.example.stoxlk.util.scaleWidth

@Composable
fun SharePricesSection(onStockClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 16f.scaleWidth())) {
        Text("Today's Share Prices", fontSize = 18f.scaleFontSize(), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12f.scaleHeight()))

        // Filter Chip
        Surface(
            shape = RoundedCornerShape(20f.scaleWidth()),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color.LightGray),
            color = StoxCardBg,
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12f.scaleWidth(), vertical = 8f.scaleHeight()),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(Icons.Default.FilterList, contentDescription = null, modifier = Modifier.size(16f.scaleWidth()))
                Spacer(modifier = Modifier.width(8f.scaleWidth()))
                Text("All Sectors", fontSize = 14f.scaleFontSize())
                Spacer(modifier = Modifier.width(4f.scaleWidth()))
                Icon(Icons.Default.ArrowDropDown, contentDescription = null, modifier = Modifier.size(20f.scaleWidth()))
            }
        }

        Spacer(modifier = Modifier.height(16f.scaleHeight()))

        // Header Row
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("COMPANY", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary, fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f))
            Text("PRICE", fontSize = 12f.scaleFontSize(), color = StoxTextSecondary, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text(
                "VOL",
                fontSize = 12f.scaleFontSize(),
                color = StoxTextSecondary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.5f),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
            )
        }

        Spacer(modifier = Modifier.height(8f.scaleHeight()))

        // List
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12f.scaleWidth()),
            colors = CardDefaults.cardColors(containerColor = StoxCardBg),
        ) {
            Column {
                SharePriceItem("HNB.N0000", "Hatton National Bank", "180.50", "+1.2%", "1.2M", onClick = { onStockClick("HNB.N0000") })
                Divider(color = StoxDivider)
                SharePriceItem("LLUB.N0000", "Chevron Lubricants", "85.00", "-0.5%", "540K", onClick = { onStockClick("LLUB.N0000") })
                Divider(color = StoxDivider)
                SharePriceItem("HAYL.N0000", "Hayleys PLC", "92.30", "0.0%", "890K", onClick = { onStockClick("HAYL.N0000") })
                Divider(color = StoxDivider)
                SharePriceItem("COMB.N0000", "Commercial Bank", "64.50", "+0.4%", "2.1M", onClick = { onStockClick("COMB.N0000") })
            }
        }
    }
}

@Composable
fun SharePriceItem(
    code: String,
    name: String,
    price: String,
    change: String,
    vol: String,
    onClick: () -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(16f.scaleWidth()),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(2f)) {
            Text(code, fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
            Text(name, fontSize = 12f.scaleFontSize(), color = StoxTextSecondary)
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(price, fontWeight = FontWeight.Bold, fontSize = 14f.scaleFontSize())
            Text(
                change,
                fontSize = 12f.scaleFontSize(),
                color =
                    if (change.contains("+")) {
                        StoxGreen
                    } else if (change.contains("-")) {
                        StoxRed
                    } else {
                        StoxTextSecondary
                    },
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            vol,
            fontSize = 14f.scaleFontSize(),
            color = StoxTextPrimary,
            modifier = Modifier.weight(0.5f),
            textAlign = androidx.compose.ui.text.style.TextAlign.End,
        )
    }
}
