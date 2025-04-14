package com.jimmy.trello.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jimmy.trello.data.Result
import androidx.navigation.NavController
import com.jimmy.trello.reusefunction.AppBarView
import com.jimmy.trello.R
import com.jimmy.trello.reusefunction.TextFieldStyle
import com.jimmy.trello.viewmodel.AuthViewModel
import androidx.compose.ui.platform.LocalContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {
    Scaffold(
        topBar = { AppBarView("Sign In", onBackNavClicked = { navController.navigateUp() }) }
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val result by authViewModel.authResult.observeAsState()
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontFamily = kFont,
                    fontSize = 60.sp,
                    color = colorResource(R.color.boardify)
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
                                authViewModel.login(email, password)
                                when (result){
                                    is Result.Success ->{
                                        // TODO : onSignInSuccess()
                                        // TODO : cannot immediate login right after signup
                                        Toast.makeText(context, "Sign in successful", Toast.LENGTH_SHORT).show()
                                    }
                                    is Result.Error -> {

                                    }
                                    else -> {

                                    }
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            elevation = ButtonDefaults.buttonElevation(0.dp),
                            contentPadding = PaddingValues(vertical = 12.dp)
                        ) {
                            Text("SIGN IN", color = Color.White)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Don't have an account? Sign Up",
                            style = MaterialTheme.typography.body2,
                            color = Color(0xFF0A80F5),
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.SignUpView.route)
                            }
                        )
                    }
                }
            }

        }
    }
}

