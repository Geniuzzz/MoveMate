package com.geniuz.movemate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.geniuz.movemate.ui.components.TopSection

@Composable
fun CalculateScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        TopSection(false) {}
        Spacer(modifier = Modifier.weight(1f))
    }
}