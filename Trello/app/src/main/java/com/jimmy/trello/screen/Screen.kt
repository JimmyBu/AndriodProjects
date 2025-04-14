package com.jimmy.trello.screen

sealed class Screen (val route : String) {
    object SplashView : Screen("splash")
    object HomeView : Screen("home")
    object LoginView : Screen("login")
    object SignUpView: Screen("signup")
}