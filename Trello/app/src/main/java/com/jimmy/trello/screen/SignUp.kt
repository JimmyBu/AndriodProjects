package com.jimmy.trello.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jimmy.trello.reusefunction.AppBarView
import com.jimmy.trello.R
import com.jimmy.trello.reusefunction.TextFieldStyle
import com.jimmy.trello.viewmodel.AuthViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUp(navController: NavController, authViewModel: AuthViewModel) {
    Scaffold(
        topBar = { AppBarView(title = "Sign Up", onBackNavClicked = { navController.navigateUp() }) }
    ) {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        val onSignUpClick = {
            if (password == confirmPassword) {
                // TODO: PROCEED
            } else {
                // TODO: ERROR AND RED TEXT
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Account",
                style = TextStyle(
                    fontFamily = kFont,
                    fontSize = 60.sp,
                    color = colorResource(R.color.boardify)
                )
            )

            Spacer(Modifier.padding(8.dp))
            Text(
                text = "Enter your name, email, and password to register with us.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = kFont,
                    color = Color.LightGray
                )
            )

            Spacer(Modifier.padding(8.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = 6.dp,
                shape = MaterialTheme.shapes.small
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TextFieldStyle(
                        label = "Username",
                        value = username,
                        onValueChanged = { username = it }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextFieldStyle(
                        label = "Email",
                        value = email,
                        onValueChanged = { email = it }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextFieldStyle(
                        label = "Password",
                        value = password,
                        onValueChanged = { password = it }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextFieldStyle(
                        label = "Confirm Password",
                        value = confirmPassword,
                        onValueChanged = { confirmPassword = it }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
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
                        androidx.compose.material3.Button(
                            onClick = {
                                authViewModel.registerUser(
                                    name = username,
                                    email = email,
                                    password = password,
                                    confirmPassword = confirmPassword,
                                )
                                username = ""
                                email = ""
                                password = ""
                                confirmPassword = ""
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            elevation = ButtonDefaults.buttonElevation(0.dp),
                            contentPadding = PaddingValues(vertical = 12.dp)
                        ) {
                            Text("SIGN UP", color = Color.White)
                        }
                    }
                }
            }



            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account? Sign In",
                    style = MaterialTheme.typography.body2,
                    color = Color(0xFF0A80F5),
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.LoginView.route)
                    }
                )
            }
        }
    }
}


