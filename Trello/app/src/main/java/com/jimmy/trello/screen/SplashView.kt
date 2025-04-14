package com.jimmy.trello.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.jimmy.trello.R
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Screen.HomeView.route) {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.boardify)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.boardify),
            contentDescription = "App Logo",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}
