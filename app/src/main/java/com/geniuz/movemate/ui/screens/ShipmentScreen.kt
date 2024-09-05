package com.geniuz.movemate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geniuz.movemate.ui.pxToDp
import com.geniuz.movemate.ui.theme.OrangeColor
import com.geniuz.movemate.ui.theme.Purple40
import com.geniuz.movemate.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShipmentScreen(navController: NavController) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Column(
        Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 40.dp),
                    text = "Shipment history",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
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

        ShipmentFilters(selectedIndex) {
            selectedIndex = it
        }
    }
}

@Composable
fun ShipmentFilters(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {

    LazyRow(
        Modifier
            .fillMaxWidth()
            .background(Purple40)
    ) {
        itemsIndexed(dummyFilters) { i, filter ->
            ShipmentFilter(
                filter,
                i == selectedIndex
            ) {
                onItemSelected(i)
            }
        }
    }
}

@Composable
fun ShipmentFilter(
    shipmentFilter: ShipmentFilter,
    isSelected: Boolean,
    onClick: () -> Unit,
) {

    var filterWidth: Int by remember {
        mutableStateOf(0)
    }

    Column(
        Modifier
            .padding(horizontal = 8.dp)
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .onGloballyPositioned {
                    filterWidth = it.size.width
                }
        ) {
            Text(
                text = shipmentFilter.name,
                color = Color.White
            )

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 16.dp)
                    .background(
                        if (isSelected) OrangeColor else Purple80,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 2.dp),
                text = "${shipmentFilter.count}",
                color = Color.White
            )
        }

        Box(
            modifier = Modifier
                .width(filterWidth.pxToDp())
                .height(3.dp)
                .background(if (isSelected) OrangeColor else Color.Transparent),
        )
    }
}

data class ShipmentFilter(
    val name: String,
    val count: Int
)

private val dummyFilters = listOf(
    ShipmentFilter("All", 12),
    ShipmentFilter("Completed", 5),
    ShipmentFilter("In progress", 3),
    ShipmentFilter("Pending", 4),
    ShipmentFilter("Cancelled", 0),
)