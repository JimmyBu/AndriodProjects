package com.jimmy.chatme.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import com.jimmy.chatme.data.Result

class MessageRepository(private val firestore : FirebaseFirestore) {
    suspend fun sendMessage(roomId: String, message: Message): Result<Unit> = try{
        firestore.collection("rooms").document(roomId)
            .collection("messages").add(message).await()
        Result.Success(Unit)
    }catch (e: Exception){
        Result.Error(e)
    }

    fun getChatMessages(roomId: String): Flow<List<Message>> = callbackFlow {
        val currentUserEmail = FirebaseAuth.getInstance().currentUser?.email ?: ""

        val subscription = firestore.collection("rooms")
            .document(roomId)
            .collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { querySnapshot, _ ->
                querySnapshot?.let { snapshot ->
                    val messages = snapshot.documents.mapNotNull { doc ->
                        doc.toObject(Message::class.java)?.let { message ->
                            val isCurrentUser = (doc.getString("senderId") == currentUserEmail)

                            message.copy(isSentByCurrentUser = isCurrentUser)
                        }
                    }
                    trySend(messages)
                }
            }

        awaitClose { subscription.remove() }
    }
}