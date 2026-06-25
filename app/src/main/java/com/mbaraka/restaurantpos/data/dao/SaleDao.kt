package com.mbaraka.restaurantpos.data.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mbaraka.restaurantpos.data.entity.Sale

@Dao
interface SaleDao {

    @Insert
    suspend fun insertSale(
        sale: Sale
    ): Long

    @Query("""
        SELECT *
        FROM sales
        ORDER BY sale_date DESC
    """)
    fun getAllSales(): LiveData<List<Sale>>

    @Query("""
        SELECT *
        FROM sales
        WHERE sale_id = :saleId
        LIMIT 1
    """)
    suspend fun getSaleById(
        saleId: Int
    ): Sale?

    @Query("""
        SELECT COUNT(*)
        FROM sales
    """)
    suspend fun getSalesCount(): Int

    @Query("""
    SELECT COUNT(*)
    FROM sales
""")
    fun observeSalesCount(): LiveData<Int>
}
