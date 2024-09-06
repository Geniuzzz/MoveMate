package com.geniuz.movemate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DropDownSelector(
    options: List<String>
) {

    var isExpanded by remember { mutableStateOf(false) }

    var selected by remember { mutableStateOf(options.firstOrNull().orEmpty()) }

    Row(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .clickable { isExpanded = !isExpanded },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(modifier = Modifier
            .padding(horizontal = 12.dp)
            .size(20.dp)
            .background(Color.Gray)
        )

        Box(modifier = Modifier
            .width(1.dp)
            .background(Color.LightGray)
            .height(20.dp)
        )

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = selected,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = if (isExpanded) Icons.Filled.KeyboardArrowRight else Icons.Filled.KeyboardArrowDown,
            contentDescription = ""
        )

        SingleChoiceDropdown(
            options = options,
            isExpanded = isExpanded,
            onExpanded = { isExpanded = it },
            onSelected = { item ->
                selected = item
            }
        )
    }
}

@Composable
private fun SingleChoiceDropdown(
    options: List<String>,
    isExpanded: Boolean,
    onExpanded: (Boolean) -> Unit,
    onSelected: (String) -> Unit
) {
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),
        expanded = isExpanded,
        onDismissRequest = { onExpanded(false) }
    ) {

        options.forEach { option ->
            DropdownMenuItem(
                text = {
                    Text(text = option)
                },
                onClick = {
                    onSelected(option)
                    onExpanded(false)
                },
            )
        }
    }
}