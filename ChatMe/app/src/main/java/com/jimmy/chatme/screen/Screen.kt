package com.jimmy.chatme.screen

sealed class Screen(val route : String){
    object LoginScreen:Screen("loginscreen")
    object SignUpScreen:Screen("signupscreen")
    object ChatRoomsScreen:Screen("chatroomscreen")
    object ChatScreen:Screen("chatscreen")
}