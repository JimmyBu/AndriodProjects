package com.jimmy.trello.viewmodel

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.jimmy.trello.Injection
import com.jimmy.trello.data.UserRepository
import kotlinx.coroutines.launch
import com.jimmy.trello.data.Result

class AuthViewModel : ViewModel() {
    private val userRepository : UserRepository

    init {
        userRepository = UserRepository (
            FirebaseAuth.getInstance(),
            Injection.instance()
        )
    }

    private val _authResult = MutableLiveData<Result<Boolean>>()
    val authResult : LiveData<Result<Boolean>> get() = _authResult


    fun registerUser(name: String,
                     email: String,
                     password: String,
                     confirmPassword: String,
    ) {
        if (password != confirmPassword) {
            _authResult.value = Result.Error(Exception("Passwords do not match"))
            return
        }

        viewModelScope.launch {
            val result = userRepository.signUp(name, email, password)
            _authResult.value = result
        }
    }

    fun login(email: String, password: String){
        viewModelScope.launch {
            _authResult.value = userRepository.login(email, password)
        }
    }
}