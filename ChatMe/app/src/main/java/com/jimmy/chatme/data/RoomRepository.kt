package com.jimmy.chatme.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RoomRepository(
    private val _firestore : FirebaseFirestore
) {
    suspend fun createRoom (name: String) : Result<Unit> = try{
        val room = Room(name = name)
        _firestore.collection("rooms").add(room).await()
        Result.Success(Unit)
    }catch (e: Exception){
        Result.Error(e)
    }

    suspend fun getRooms () : Result<List<Room>> = try {
        val querySnapshot = _firestore.collection("rooms").get().await()
        val rooms = querySnapshot.documents.map { document ->
            document.toObject(Room :: class.java) !!.copy(id = document.id)
        }
        Result.Success(rooms)
    }catch (e: Exception){
        Result.Error(e)
    }
}