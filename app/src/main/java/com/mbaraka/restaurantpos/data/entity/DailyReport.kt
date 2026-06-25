package com.mbaraka.restaurantpos.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "daily_reports",
    indices = [
        Index(value = ["report_date"], unique = true)
    ]
)
data class DailyReport(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "report_id")
    val reportId: Int = 0,

    @ColumnInfo(name = "report_date")
    val reportDate: String,

    @ColumnInfo(name = "total_sales")
    val totalSales: Double = 0.0,

    @ColumnInfo(name = "total_transactions")
    val totalTransactions: Int = 0,

    @ColumnInfo(name = "total_items_sold")
    val totalItemsSold: Int = 0,

    @ColumnInfo(name = "total_profit")
    val totalProfit: Double = 0.0,

    @ColumnInfo(name = "last_reset")
    val lastReset: Long = System.currentTimeMillis()
)