package com.mbaraka.restaurantpos.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mbaraka.restaurantpos.data.dao.DailyReportDao
import com.mbaraka.restaurantpos.data.dao.ProductDao
import com.mbaraka.restaurantpos.data.dao.SaleDao
import com.mbaraka.restaurantpos.data.dao.SaleItemDao
import com.mbaraka.restaurantpos.ui.DrinkDao
import com.mbaraka.restaurantpos.ui.DrinkEntity
import com.mbaraka.restaurantpos.data.entity.DailyReport
import com.mbaraka.restaurantpos.data.entity.Product
import com.mbaraka.restaurantpos.data.entity.Sale
import com.mbaraka.restaurantpos.data.entity.SaleItem

@Database(
    entities = [
        DrinkEntity::class,
        Product::class,
        Sale::class,
        SaleItem::class,
        DailyReport::class
    ],
    version = 6,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao
    abstract fun productDao(): ProductDao
    abstract fun saleDao(): SaleDao
    abstract fun saleItemDao(): SaleItemDao
    abstract fun dailyReportDao(): DailyReportDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "restaurant_pos_final_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
