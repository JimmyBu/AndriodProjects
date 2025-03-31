package com.jimmy.workoutapp

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun ExerciseView(navController: NavController, exerciseName: String, exerciseImage: Int){
    Scaffold (
        topBar = {
            AppBarView(
                "WorkOut App",
                onBackNavClicked = { navController.navigateUp() }
            )
        }
    ){
        paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = exerciseImage),
                    contentDescription = exerciseName,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(4.dp, Color.Black, CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = exerciseName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                CountdownButtonWithProgressBar()
            }
        }
    }
}

@Composable
fun CountdownButtonWithProgressBar() {
    var totalTime = 60
    var timeLeft by remember { mutableStateOf(totalTime) }
    var isRunning by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = 1f - (timeLeft.toFloat() / totalTime.toFloat()),
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    LaunchedEffect(isRunning) {
        if (isRunning) {
            while (timeLeft >= 0) {
                delay(1000)
                timeLeft -= 1
            }
        }
    }

    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
            .clip(CircleShape)
            .border(4.dp, Color.Black, CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Black, CircleShape)
                .graphicsLayer(rotationZ = 0f)
        ) {
            CircularProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.Center),
                color = colorResource(id = R.color.progress_bar_color),
                strokeWidth = 10.dp
            )
        }

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .clickable {
                    if (!isRunning) {
                        timeLeft = totalTime
                        isRunning = true
                    }
                }
                .background(color = colorResource(id = R.color.progress_bar_color)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (timeLeft < 0) "START" else "$timeLeft",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}