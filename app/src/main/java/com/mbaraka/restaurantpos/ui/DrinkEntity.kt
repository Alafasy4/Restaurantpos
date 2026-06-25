package com.mbaraka.restaurantpos.ui

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinks")
data class DrinkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Int,
    val stock: Int
)