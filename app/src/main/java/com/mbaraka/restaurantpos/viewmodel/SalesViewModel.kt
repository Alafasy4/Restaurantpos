package com.mbaraka.restaurantpos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mbaraka.restaurantpos.data.database.DatabaseProvider
import com.mbaraka.restaurantpos.data.entity.Sale
import com.mbaraka.restaurantpos.data.repository.SaleRepository

class SalesViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository: SaleRepository

    val allSales: LiveData<List<Sale>>

    init {

        val saleDao = DatabaseProvider
            .getDatabase(application)
            .saleDao()

        repository = SaleRepository(saleDao)

        allSales = repository.allSales

    }

}