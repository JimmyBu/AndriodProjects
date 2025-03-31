package com.jimmy.workoutapp

sealed class Screen(val route: String) {
    object Start : Screen("startscreen")
    object ExerciseList : Screen("exerciselist")
    object Exercise : Screen("exercise/{exerciseName}/{exerciseImage}") {
        fun passArguments(exerciseName: String, exerciseImage: Int): String {
            return "exercise/$exerciseName/$exerciseImage"
        }
    }
}
