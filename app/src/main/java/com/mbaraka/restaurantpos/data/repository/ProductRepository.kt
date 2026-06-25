package com.mbaraka.restaurantpos.data.repository



import androidx.lifecycle.LiveData
import com.mbaraka.restaurantpos.data.dao.ProductDao
import com.mbaraka.restaurantpos.data.entity.Product

class ProductRepository(
    private val productDao: ProductDao
) {

    val allProducts: LiveData<List<Product>> =
        productDao.getAllProducts()

    fun getLowStockProducts() =
        productDao.getLowStockProducts()

    fun searchProducts(keyword: String) =
        productDao.searchProducts(keyword)

    suspend fun insertProduct(
        product: Product
    ) {
        productDao.insertProduct(product)
    }

    suspend fun updateProduct(
        product: Product
    ) {
        productDao.updateProduct(product)
    }

    suspend fun deactivateProduct(
        productId: Int
    ) {
        productDao.deactivateProduct(productId)
    }

    suspend fun updateStock(
        productId: Int,
        newStock: Int
    ) {
        productDao.updateStock(
            productId,
            newStock
        )
    }

}