package com.jimmy.chatme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimmy.chatme.Injection
import com.jimmy.chatme.data.Result
import com.jimmy.chatme.data.Room
import com.jimmy.chatme.data.RoomRepository
import kotlinx.coroutines.launch

class RoomViewModel : ViewModel(){
    private val _rooms = MutableLiveData<List<Room>>()
    val rooms : LiveData<List<Room>> get() = _rooms
    private val roomRepository: RoomRepository

    init {
        roomRepository = RoomRepository(Injection.instance())
        loadRooms()
    }

    fun createRoom ( name : String){
        viewModelScope.launch {
            roomRepository.createRoom(name)
            loadRooms()
        }
    }

    fun loadRooms(){
        viewModelScope.launch {
            when (val result = roomRepository.getRooms()){
                is Result.Success -> _rooms.value = result.data

                is Result.Error -> {

                }
            }
        }
    }
}