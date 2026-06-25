package com.mbaraka.restaurantpos.data.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mbaraka.restaurantpos.data.entity.SaleItem

@Dao
interface SaleItemDao {

    @Insert
    suspend fun insertSaleItem(
        saleItem: SaleItem
    )

    @Insert
    suspend fun insertSaleItems(
        saleItems: List<SaleItem>
    )

    @Query("""
        SELECT *
        FROM sale_items
        WHERE sale_id = :saleId
        ORDER BY sale_item_id ASC
    """)
    suspend fun getItemsForSale(
        saleId: Int
    ): List<SaleItem>

}
