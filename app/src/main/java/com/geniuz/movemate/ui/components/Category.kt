package com.geniuz.movemate.ui.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.geniuz.movemate.ui.screens.categories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Category(
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        modifier = Modifier.padding(end = 4.dp),
        selected = isSelected,
        onClick = { onClick() },
        label = { Text(text = name) }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Categories() {
    var selected by remember {
        mutableStateOf("")
    }

    FlowRow {
        categories.forEach { name ->
            Category(name, name == selected) {
                selected = name
            }
        }
    }
}