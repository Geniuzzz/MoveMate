package com.geniuz.movemate.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geniuz.movemate.ui.theme.Purple40

@Preview
@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopSection()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSection() {
    var searchText by remember { mutableStateOf("") }
    var isNormalMode by remember { mutableStateOf(true) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple40)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        AnimatedVisibility(visible = isNormalMode) {
            TopBar()
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            AnimatedVisibility(visible = !isNormalMode) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            focusManager.clearFocus()
                            isNormalMode = true
                        },
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    tint = Color.White,
                    contentDescription = ""
                )
            }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .padding(vertical = 16.dp)
                    .onFocusChanged {
                        if (it.isFocused) {
                            isNormalMode = false
                        }
                    },
                shape = RoundedCornerShape(100),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                ),
                value = searchText,
                onValueChange = {
                    searchText = it

                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        tint = Purple40,
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "search"
                    )
                }
            )
        }

    }


}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
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
                    color = Color.LightGray
                )
            }
            Text(
                text = "Wertheimer, Illinois",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier
                .size(60.dp)
                .background(Color.White, CircleShape)
                .padding(8.dp),
            imageVector = Icons.Outlined.Notifications,
            contentDescription = ""
        )
    }
}