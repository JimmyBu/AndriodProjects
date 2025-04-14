package com.jimmy.trello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.jimmy.trello.screen.HomeView
import com.jimmy.trello.screen.LoginScreen
import com.jimmy.trello.screen.Screen
import com.jimmy.trello.screen.SignUp
import com.jimmy.trello.screen.SplashView
import com.jimmy.trello.ui.theme.TrelloTheme
import com.jimmy.trello.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val authViewModel : AuthViewModel = viewModel()
            TrelloTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    AppNavigation(navController, authViewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavController, viewModel: AuthViewModel) {

    NavHost(navController = navController as NavHostController, startDestination = "splash") {
        composable(Screen.SplashView.route) { SplashView(navController) }
        composable(Screen.HomeView.route){ HomeView(navController) }
        composable(Screen.LoginView.route) { LoginScreen(navController, viewModel) }
        composable(Screen.SignUpView.route){ SignUp(navController, viewModel) }
    }
}
