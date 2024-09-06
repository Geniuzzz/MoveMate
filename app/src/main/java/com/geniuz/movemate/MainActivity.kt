package com.geniuz.movemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.geniuz.movemate.ui.components.BottomBarDestinations
import com.geniuz.movemate.ui.screens.CalculateScreen
import com.geniuz.movemate.ui.screens.HomeScreen
import com.geniuz.movemate.ui.screens.ShipmentScreen
import com.geniuz.movemate.ui.theme.MoveMateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoveMateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MoveMateNavHost(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun MoveMateNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarDestinations.HOME.name) {

        BottomBarDestinations.values().forEach { destination ->
            composable(destination.name) {
                when (destination) {
                    BottomBarDestinations.HOME -> {
                        HomeScreen(navController)
                    }

                    BottomBarDestinations.CALCULATE -> {
                        CalculateScreen(navController)
                    }

                    BottomBarDestinations.SHIPMENT -> {
                        ShipmentScreen(navController)
                    }

                    BottomBarDestinations.PROFILE -> {

                    }
                }
            }
        }
    }
}