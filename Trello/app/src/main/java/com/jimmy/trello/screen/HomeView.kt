package com.jimmy.trello.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jimmy.trello.R

val kFont = FontFamily(
    Font(R.font.kopikoo)
)

@Composable
fun HomeView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Boardify",
            style = TextStyle(
                fontFamily = kFont,
                fontSize = 60.sp,
                color = colorResource(R.color.boardify)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_task_image),
                contentDescription = "Task Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }


        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Let's get started",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Collaborate and plan together across multiple devices on Boardify's minimalist interface",
                style = TextStyle(fontSize = 16.sp, color = Color.LightGray),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF0BCBEB),
                            Color(0xFF0A80F5)
                        )
                    ),
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Button(
                onClick = { navController.navigate(Screen.LoginView.route) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                Text("SIGN IN", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.White,
                            Color.White
                        )
                    ),
                    shape = MaterialTheme.shapes.medium,
                )
                .border(1.dp, colorResource(id = R.color.buttonBlue), MaterialTheme.shapes.medium)
        ) {
            Button(
                onClick = { navController.navigate(Screen.SignUpView.route) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                Text("SIGN UP", color = colorResource(id = R.color.buttonBlue))
            }
        }
    }
}

