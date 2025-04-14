package com.jimmy.trello.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository (
    private val auth : FirebaseAuth,
    private val firestore : FirebaseFirestore
){
    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<Boolean> = try {
        auth.createUserWithEmailAndPassword(email, password).await()

        // Get the Firebase UID
        val uid = auth.currentUser?.uid ?: throw Exception("User ID not found")

        // Save user info in Firestore, as they handles the password
        val user = User(name, email)
        saveUserToFireStore(uid, user)

        Result.Success(true)
    } catch (e: Exception) {
        Result.Error(e)
    }

    private suspend fun saveUserToFireStore(uid: String, user: User) {
        try {
            firestore.collection("users").document(uid).set(user).await()
        } catch (e: Exception) {
            throw Exception("Error saving user to Firestore: ${e.message}")
        }
    }

    suspend fun login(email: String, password: String): Result<Boolean> = try {
        auth.signInWithEmailAndPassword(email, password).await()
        Result.Success(true)
    }catch (e: Exception){
        Result.Error(e)
    }

    suspend fun getCurrentUser(): Result<User> = try {
        val uid = auth.currentUser?.uid // Use UID for Firestore lookup
        if (uid != null) {
            val userDocument = firestore.collection("users").document(uid).get().await()
            val user = userDocument.toObject(User::class.java)
            if (user != null) {
                Log.d("user2", "$uid")
                Result.Success(user)
            } else {
                Result.Error(Exception("User Data Not Found"))
            }
        } else {
            Result.Error(Exception("User not authenticated"))
        }
    } catch (e: Exception) {
        Result.Error(e)
    }
}