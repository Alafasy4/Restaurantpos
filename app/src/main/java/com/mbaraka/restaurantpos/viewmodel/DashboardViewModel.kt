package com.mbaraka.restaurantpos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mbaraka.restaurantpos.data.database.DatabaseProvider

class DashboardViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val database =
        DatabaseProvider.getDatabase(application)

    val totalProducts =
        database.productDao().getProductCount()

    val lowStockProducts =
        database.productDao().getLowStockProducts()

    val totalSales =
        database.saleDao().observeSalesCount()

}