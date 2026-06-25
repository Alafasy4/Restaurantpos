package com.mbaraka.restaurantpos.ui

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DrinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: DrinkEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drinks: List<DrinkEntity>)

    @Query("SELECT * FROM drinks ORDER BY name ASC")
    suspend fun getAllDrinks(): List<DrinkEntity>

    @Query("SELECT * FROM drinks WHERE id = :drinkId LIMIT 1")
    suspend fun getDrinkById(drinkId: Int): DrinkEntity?

    @Update
    suspend fun updateDrink(drink: DrinkEntity)

    @Query("SELECT COUNT(*) FROM drinks")
    suspend fun getCount(): Int
}