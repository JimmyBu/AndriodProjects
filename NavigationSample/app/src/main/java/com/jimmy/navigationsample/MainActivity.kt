package com.jimmy.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.jimmy.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen"){
        composable("firstscreen"){
            FirstScreen {
                name, age ->
                val resolvedName = name.ifBlank { "no name" }
                val age = age
                navController.navigate("secondscreen/$resolvedName/$age")
            }
        }
        composable("secondscreen/{name}/{age}"){
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age")?.toIntOrNull() ?: 0
            SecondScreen (name, age) {
                name, age ->
                navController.navigate("thirdscreen/$name/$age")
            }
        }
        composable("thirdscreen/{name}/{age}"){
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age")?.toIntOrNull() ?: 0
            ThirdScreen (name, age){
                navController.navigate("firstscreen")
            }
        }
    }

}