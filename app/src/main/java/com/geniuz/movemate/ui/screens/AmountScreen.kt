package com.geniuz.movemate.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.geniuz.movemate.R
import com.geniuz.movemate.ui.theme.OrangeColor
import kotlinx.coroutines.launch

@Composable
fun AmountScreen(navController: NavController) {

    val amountAnimation = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = Unit) {
        launch {
            amountAnimation.animateTo(1460f, tween(3000))
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.height(100.dp),
            painter = painterResource(id = R.drawable.movemate_logo),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Total Estimated Amount")

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Medium, fontSize = 24.sp)) {
                    append("$${amountAnimation.value.toInt()}")
                }
                withStyle(SpanStyle(fontSize = 20.sp)) {
                    append("USD")
                }
            },
            color = Color(0XFF2EC57D),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "This amount is estimated this will vary\nif you change your location or weight",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(
                containerColor = OrangeColor
            )
        ) {
            Text(
                text = "Back to home",
                color = Color.White,
            )
        }
    }
}