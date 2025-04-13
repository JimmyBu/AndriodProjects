package com.jimmy.chatme

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jimmy.chatme.screen.ChatRoomListScreen
import com.jimmy.chatme.screen.ChatScreen
import com.jimmy.chatme.screen.LoginScreen
import com.jimmy.chatme.screen.Screen
import com.jimmy.chatme.screen.SignUpScreen
import com.jimmy.chatme.ui.theme.ChatMeTheme
import com.jimmy.chatme.viewmodel.AuthViewModel
import com.jimmy.chatme.viewmodel.MessageViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val authViewModel : AuthViewModel = viewModel()
            ChatMeTheme {
                Surface (modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Navigation(navController, authViewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation (
    navController: NavController,
    viewModel: AuthViewModel,
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.LoginScreen.route,
    ) {
        composable(Screen.SignUpScreen.route){
            SignUpScreen(
                authViewModel = viewModel,
                onNavigateToLogin = {navController.navigate(Screen.LoginScreen.route)},
                onNavigateUp = {navController.navigateUp()}
            )
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(
                authViewModel = viewModel,
                onNavigateToSignUp = {navController.navigate(Screen.SignUpScreen.route)},
            ){
                navController.navigate(Screen.ChatRoomsScreen.route)
            }
        }
        composable(Screen.ChatRoomsScreen.route) {
            ChatRoomListScreen{
                navController.navigate("${Screen.ChatScreen.route}/${it.id}")
            }
        }

        composable("${Screen.ChatScreen.route}/{roomId}"){
            val roomId : String = it.arguments?.getString("roomId") ?: ""
            val vm : MessageViewModel = viewModel()
            ChatScreen(roomId = roomId, viewModel = vm)
        }
    }
}