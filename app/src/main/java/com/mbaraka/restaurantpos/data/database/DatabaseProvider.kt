package com.mbaraka.restaurantpos.data.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {

        return INSTANCE ?: synchronized(this) {

            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "vinywaji_pro_database"
            )
                .fallbackToDestructiveMigration()
                .build()

            INSTANCE = instance

            instance
        }
    }
}