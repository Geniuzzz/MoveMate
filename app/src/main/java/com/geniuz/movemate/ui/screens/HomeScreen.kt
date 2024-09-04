package com.geniuz.movemate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geniuz.movemate.ui.components.BottomNavigationBar
import com.geniuz.movemate.ui.components.TopSection

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        TopSection()
        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationBar(navController)
    }
}
