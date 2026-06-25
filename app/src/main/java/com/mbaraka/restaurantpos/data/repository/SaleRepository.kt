package com.mbaraka.restaurantpos.data.repository


import androidx.lifecycle.LiveData
import com.mbaraka.restaurantpos.data.dao.SaleDao
import com.mbaraka.restaurantpos.data.entity.Sale

class SaleRepository(
    private val saleDao: SaleDao
) {

    val allSales: LiveData<List<Sale>> =
        saleDao.getAllSales()

    suspend fun insertSale(
        sale: Sale
    ): Long {

        return saleDao.insertSale(sale)

    }

    suspend fun getSaleById(
        saleId: Int
    ): Sale? {

        return saleDao.getSaleById(saleId)

    }

    suspend fun getSalesCount(): Int {

        return saleDao.getSalesCount()

    }

}