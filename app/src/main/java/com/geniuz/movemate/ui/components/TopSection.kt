package com.geniuz.movemate.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.geniuz.movemate.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSection(isFullScreen: Boolean, onFullScreen: (Boolean) -> Unit) {
    var searchText by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple40)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        AnimatedVisibility(visible = !isFullScreen) {
            TopBar()
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            AnimatedVisibility(visible = isFullScreen) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            focusManager.clearFocus()
                            onFullScreen(false)
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
                            onFullScreen(true)
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