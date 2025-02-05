package com.jimmy.wishlistapp

import android.content.Context
import androidx.room.Room
import com.jimmy.wishlistapp.data.WishDataBase
import com.jimmy.wishlistapp.data.WishRepository

object Graph {
    lateinit var dataBase: WishDataBase

    val wishRepository by lazy{
        WishRepository(dataBase.wishDao())
    }

    fun provide(context : Context){
        dataBase = Room.databaseBuilder(
            context,
            WishDataBase::class.java,
            "wishlist.db")
            .build()
    }
}