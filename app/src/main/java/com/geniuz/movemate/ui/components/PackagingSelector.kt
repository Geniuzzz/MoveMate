package com.geniuz.movemate.ui.components

import androidx.compose.runtime.Composable

@Composable
fun PackagingSelector() {
    DropDownSelector(
        options = listOf("Box", "Carton")
    )
}