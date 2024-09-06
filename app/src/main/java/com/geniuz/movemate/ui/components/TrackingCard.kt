package com.geniuz.movemate.ui.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geniuz.movemate.ui.theme.OrangeColor

@Composable
fun TrackingCard(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "Shipment Number",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "N124T2T46284298",
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray)
            )

            TrackingUserCard(
                type = "Sender",
                location = "Atlanta, 5243",
                status = "Time",
                details = "2 days - 3 days"
            )

            TrackingUserCard(
                type = "Receiver",
                location = "Chicago, 6342",
                status = "Status",
                details = "Waiting to collect"
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                tint = OrangeColor,
                contentDescription = "add"
            )

            Text(text = "Add Stop", color = OrangeColor)
        }
    }
}

@Composable
fun TrackingUserCard(
    type: String,
    location: String,
    status: String,
    details: String,
) {
    Row {

        Row(
            Modifier
                .padding(vertical = 16.dp)
                .padding(end = 8.dp)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(if (type == "Sender") Color(0x4DFF8080) else Color(0x3300BCD4))
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = type,
                    color = Color.LightGray,
                    fontSize = 14.sp
                )

                Text(
                    text = location
                )
            }
        }


        Row(
            Modifier
                .padding(vertical = 16.dp)
                .padding(start = 8.dp)
                .weight(1f)
        ) {

            Column {
                Text(
                    text = status,
                    color = Color.LightGray,
                    fontSize = 14.sp
                )

                Text(
                    text = details
                )
            }
        }

    }
}