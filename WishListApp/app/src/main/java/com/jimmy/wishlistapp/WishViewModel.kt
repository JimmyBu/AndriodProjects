package com.jimmy.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimmy.wishlistapp.data.Wish
import com.jimmy.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
) : ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString : String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString : String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes : Flow<List<Wish>> // Flow init async so need late init
    init {
        viewModelScope.launch{
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO) {
            wishRepository.addAWish(wish)
        }
    }

    fun getAWishById(id:Long) : Flow<Wish>{
        return wishRepository.getAWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO) {
            wishRepository.updateAWish(wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO) {
            wishRepository.deleteAWish(wish)
        }
    }
}