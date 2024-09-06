package com.geniuz.movemate.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.geniuz.movemate.ui.components.Categories
import com.geniuz.movemate.ui.components.DestinationInputs
import com.geniuz.movemate.ui.components.Group
import com.geniuz.movemate.ui.components.PackagingSelector
import com.geniuz.movemate.ui.theme.OrangeColor
import com.geniuz.movemate.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        val (topBar, content, calculateBtn) = createRefs()

        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(topBar) {
                    top.linkTo(parent.top)
                },
            title = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 40.dp),
                    text = "Calculate",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
            },
            navigationIcon = {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    tint = Color.White,
                    contentDescription = "back"
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Purple40),
        )

        CalculateContent(
            Modifier
                .fillMaxWidth()
                .constrainAs(content) {
                    top.linkTo(topBar.bottom)
                    bottom.linkTo(calculateBtn.top)
                    height = Dimension.fillToConstraints
                }
                .padding(horizontal = 16.dp)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .constrainAs(calculateBtn) {
                    bottom.linkTo(parent.bottom)
                },
            colors = ButtonDefaults.buttonColors(
                containerColor = OrangeColor,
            ),
            onClick = {
                navController.navigate("amount") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
        ) {
            Text(
                text = "Calculate",
                color = Color.White
            )
        }
    }
}

@Composable
fun CalculateContent(modifier: Modifier) {
    LazyColumn(
        modifier,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Group(
                title = "Destination",
            ) {
                DestinationInputs()
            }
        }

        item {
            Group(
                title = "Packaging",
                subTitle = "What are you sending?"
            ) {
                PackagingSelector()
            }
        }

        item {
            Group(
                title = "Categories",
                subTitle = "What are you sending?"
            ) {
                Categories()
            }
        }
    }
}

val categories = listOf("Documents", "Glass", "Liquid", "Food", "Electronic", "Product", "Others")