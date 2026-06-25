package com.mbaraka.restaurantpos.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales")
data class Sale(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sale_id")
    val saleId: Int = 0,

    @ColumnInfo(name = "receipt_number")
    val receiptNumber: String,

    @ColumnInfo(name = "total_amount")
    val totalAmount: Double,

    @ColumnInfo(name = "payment_method")
    val paymentMethod: String,

    @ColumnInfo(name = "cash_received")
    val cashReceived: Double,

    @ColumnInfo(name = "change_amount")
    val changeAmount: Double,

    @ColumnInfo(name = "sale_date")
    val saleDate: Long = System.currentTimeMillis()
)