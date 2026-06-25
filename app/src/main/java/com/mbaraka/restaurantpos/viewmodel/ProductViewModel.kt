package com.mbaraka.restaurantpos.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mbaraka.restaurantpos.data.database.DatabaseProvider
import com.mbaraka.restaurantpos.data.entity.Product
import com.mbaraka.restaurantpos.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application)
    : AndroidViewModel(application) {

    private val repository: ProductRepository

    val allProducts: LiveData<List<Product>>

    val lowStockProducts: LiveData<List<Product>>

    init {

        val productDao = DatabaseProvider
            .getDatabase(application)
            .productDao()

        repository = ProductRepository(productDao)

        allProducts = repository.allProducts

        lowStockProducts = repository.getLowStockProducts()

    }

    fun insertProduct(product: Product) {

        viewModelScope.launch {

            repository.insertProduct(product)

        }

    }

    fun updateProduct(product: Product) {

        viewModelScope.launch {

            repository.updateProduct(product)

        }

    }

    fun deactivateProduct(productId: Int) {

        viewModelScope.launch {

            repository.deactivateProduct(productId)

        }

    }

    fun updateStock(
        productId: Int,
        newStock: Int
    ) {

        viewModelScope.launch {

            repository.updateStock(
                productId,
                newStock
            )

        }

    }

    fun searchProducts(keyword: String)
            : LiveData<List<Product>> {

        return repository.searchProducts(keyword)

    }

}