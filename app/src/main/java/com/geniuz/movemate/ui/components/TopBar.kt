package com.geniuz.movemate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            imageVector = Icons.Outlined.AccountCircle,
            contentDescription = ""
        )

        Column(
            Modifier.padding(start = 16.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Place,
                    tint = Color.LightGray,
                    contentDescription = ""
                )

                Text(
                    text = "Your location",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 14.sp)
                )
            }
            Text(
                text = "Wertheimer, Illinois",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White, CircleShape)
                .padding(8.dp),
            imageVector = Icons.Outlined.Notifications,
            contentDescription = ""
        )
    }
}