package com.geniuz.movemate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geniuz.movemate.ui.theme.OrangeColor
import com.geniuz.movemate.ui.theme.Purple40

@Composable
fun ShipmentDetails(shipmentDetails: ShipmentDetails) {

    val (icon, color, text) = when (shipmentDetails.state) {
        ShipmentState.IN_PROGRESS -> Triple(Icons.Filled.Refresh, Color(0XFF2EC57D), "in-progress")
        ShipmentState.PENDING -> Triple(Icons.Filled.Refresh, OrangeColor, "Pending")
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {

        // chip
        Row(
            Modifier
                .background(MaterialTheme.colorScheme.background, RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = icon,
                tint = color,
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = text,
                color = color
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = shipmentDetails.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = shipmentDetails.details,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = shipmentDetails.amount,
            fontWeight = FontWeight.SemiBold,
            color = Purple40,
        )

    }
}

data class ShipmentDetails(
    val state: ShipmentState,
    val title: String,
    val details: String,
    val amount: String
)

enum class ShipmentState {
    IN_PROGRESS, PENDING
}
