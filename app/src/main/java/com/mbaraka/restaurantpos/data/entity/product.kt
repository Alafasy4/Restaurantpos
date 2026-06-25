package com.mbaraka.restaurantpos.data.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    val productId: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "buy_price")
    val buyPrice: Double,

    @ColumnInfo(name = "sell_price")
    val sellPrice: Double,

    @ColumnInfo(name = "stock")
    val stock: Int,

    @ColumnInfo(name = "min_stock")
    val minStock: Int = 5,

    @ColumnInfo(name = "is_active")
    val isActive: Boolean = true,

    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)