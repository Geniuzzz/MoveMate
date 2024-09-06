package com.geniuz.movemate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DestinationInput(
    label: String = "Sender location"
) {
    var input by remember {
        mutableStateOf("")
    }

    Row(
        Modifier
            .height(56.dp)
            .background(
                MaterialTheme.colorScheme.background, RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.MailOutline,
            tint = Color.Gray,
            contentDescription = ""
        )

        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                .width(1.dp)
                .background(Color.Gray)
                .height(32.dp)
        )

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            maxLines = 1,
            singleLine = true,
            value = input,
            cursorBrush = SolidColor(Color.Black),
            onValueChange = {
                input = it
            },
        ) {
            val (text, color) = if (input.isEmpty()) {
                Pair(label, Color.Gray)
            } else {
                Pair(input, Color.Unspecified)
            }

            Text(
                text = text,
                color = color
            )
        }
    }
}

@Composable
fun DestinationInputs() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        DestinationInput("Sender location")
        Spacer(modifier = Modifier.height(8.dp))
        DestinationInput("Receiver location")
        Spacer(modifier = Modifier.height(8.dp))
        DestinationInput("Approx weight")
    }
}