package com.geniuz.movemate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geniuz.movemate.ui.theme.Purple40
import java.util.Locale

@Composable
fun RowScope.BottomNavigationItem(
    option: BottomBarDestinations,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(Purple40)
            )
        }

        val imageVector = when (option) {
            BottomBarDestinations.HOME -> Icons.Outlined.Home
            BottomBarDestinations.CALCULATE -> Icons.Outlined.Menu
            BottomBarDestinations.SHIPMENT -> Icons.Outlined.Refresh
            BottomBarDestinations.PROFILE -> Icons.Outlined.Person
        }

        Icon(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(24.dp),
            imageVector = imageVector,
            tint = if (isSelected) Purple40 else Color.Gray,
            contentDescription = option.name
        )

        Text(
            text = option.name.lowercase().replaceFirstChar { it.titlecase(Locale.getDefault()) },
            fontSize = 12.sp,
            color = if (isSelected) Purple40 else Color.Gray
        )
    }
}