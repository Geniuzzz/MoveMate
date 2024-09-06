package com.geniuz.movemate.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.geniuz.movemate.ui.components.BottomNavigationBar
import com.geniuz.movemate.ui.components.SearchResultUI
import com.geniuz.movemate.ui.components.TopSection
import com.geniuz.movemate.ui.components.TrackingCard

@Composable
fun HomeScreen(navController: NavController) {
    var isFullScreen by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        TopSection(isFullScreen) {
            isFullScreen = it
        }

        AnimatedVisibility(visible = !isFullScreen) {
            TrackingSection()
        }

        AnimatedVisibility(
            visible = isFullScreen,
            enter = fadeIn() + expandVertically(
                expandFrom = Alignment.Top
            ),
        ) {
            SearchResultUI(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        AnimatedVisibility(visible = !isFullScreen) {
            BottomNavigationBar(navController)
        }
    }
}

@Composable
fun TrackingSection() {
    Column(
        Modifier.padding(horizontal = 16.dp)
    ) {

        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "Tracking",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        TrackingCard()
    }
}
