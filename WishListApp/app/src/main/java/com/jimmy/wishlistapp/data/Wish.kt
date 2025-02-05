package com.jimmy.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title : String = "",
    @ColumnInfo(name = "wish-desc")
    val description : String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 1", description = "Android Watch 1"),
        Wish(title = "Google Watch 2", description = "Android Watch 2"),
        Wish(title = "Google Watch 3", description = "Android Watch 3"),
        Wish(title = "Google Watch 4", description = "Android Watch 4")
    )
}