package com.jimmy.chatme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.jimmy.chatme.Injection
import com.jimmy.chatme.data.Message
import com.jimmy.chatme.data.MessageRepository
import com.jimmy.chatme.data.Result
import com.jimmy.chatme.data.User
import com.jimmy.chatme.data.UserRepository
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel(){
    private val messageRepository : MessageRepository
    private val userRepository : UserRepository

    init {
        messageRepository = MessageRepository(Injection.instance())
        userRepository = UserRepository(FirebaseAuth.getInstance(), Injection.instance())
        loadCurrentUser()
    }

    private val _messages = MutableLiveData<List<Message>>()
    val messages : LiveData<List<Message>> get() = _messages
    private val _roomId = MutableLiveData<String>()
    private val _currentUser = MutableLiveData<User>()

    fun setRoomId(roomId : String){
        _roomId.value = roomId
        loadMessages()
    }

    fun sendMessage(text: String) {
        val roomId = _roomId.value ?: return
        val currentUser = _currentUser.value ?: return

        val message = Message(
            senderFirstName = currentUser.firstName,
            senderId = currentUser.email,
            text = text,
            timestamp = System.currentTimeMillis(),
            isSentByCurrentUser = true
        )

        viewModelScope.launch {
            when (messageRepository.sendMessage(roomId, message)) {
                is Result.Success -> Unit
                is Result.Error -> {
                }
            }
        }
    }

    fun loadMessages(){
        viewModelScope.launch {
            if(_roomId != null){
                messageRepository.getChatMessages(_roomId.value.toString())
                    .collect{_messages.value = it}
            }
        }
    }

    private fun loadCurrentUser(){
        viewModelScope.launch {
            when (val result = userRepository.getCurrentUser()){
                is Result.Success -> _currentUser.value = result.data
                is Result.Error -> {

                }
            }
        }
    }
}