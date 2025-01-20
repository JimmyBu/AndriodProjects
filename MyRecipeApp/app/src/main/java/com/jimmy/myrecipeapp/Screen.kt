package com.jimmy.myrecipeapp

import androidx.navigation.NavController

sealed class Screen (val route:String) {
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}