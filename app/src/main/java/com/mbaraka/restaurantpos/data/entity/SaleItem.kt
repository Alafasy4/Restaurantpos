package com.mbaraka.restaurantpos.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "sale_items",
    foreignKeys = [
        ForeignKey(
            entity = Sale::class,
            parentColumns = ["sale_id"],
            childColumns = ["sale_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["product_id"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index("sale_id"),
        Index("product_id")
    ]
)
data class SaleItem(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sale_item_id")
    val saleItemId: Int = 0,

    @ColumnInfo(name = "sale_id")
    val saleId: Int,

    @ColumnInfo(name = "product_id")
    val productId: Int,

    @ColumnInfo(name = "quantity")
    val quantity: Int,

    @ColumnInfo(name = "unit_price")
    val unitPrice: Double,

    @ColumnInfo(name = "subtotal")
    val subtotal: Double
)