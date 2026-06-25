package com.mbaraka.restaurantpos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mbaraka.restaurantpos.data.entity.Product

@Dao
interface ProductDao {

    // =========================
    // INSERT
    // =========================

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertProduct(product: Product)

    // =========================
    // UPDATE
    // =========================

    @Update
    suspend fun updateProduct(product: Product)

    // =========================
    // SOFT DELETE
    // =========================

    @Query("""
        UPDATE products
        SET is_active = 0
        WHERE product_id = :productId
    """)
    suspend fun deactivateProduct(productId: Int)

    // =========================
    // UPDATE STOCK
    // =========================

    @Query("""
        UPDATE products
        SET stock = :newStock
        WHERE product_id = :productId
    """)
    suspend fun updateStock(
        productId: Int,
        newStock: Int
    )

    // =========================
    // GET ALL ACTIVE PRODUCTS
    // =========================

    @Query("""
        SELECT *
        FROM products
        WHERE is_active = 1
        ORDER BY name ASC
    """)
    fun getAllProducts(): LiveData<List<Product>>

    // =========================
    // GET PRODUCT BY ID
    // =========================

    @Query("""
        SELECT *
        FROM products
        WHERE product_id = :productId
        LIMIT 1
    """)
    suspend fun getProductById(
        productId: Int
    ): Product?

    // =========================
    // SEARCH PRODUCT
    // =========================

    @Query("""
        SELECT *
        FROM products
        WHERE is_active = 1
        AND name LIKE '%' || :keyword || '%'
        ORDER BY name
    """)
    fun searchProducts(
        keyword: String
    ): LiveData<List<Product>>

    // =========================
    // LOW STOCK
    // =========================

    @Query("""
        SELECT *
        FROM products
        WHERE stock <= min_stock
        AND is_active = 1
        ORDER BY stock ASC
    """)
    fun getLowStockProducts(): LiveData<List<Product>>

    @Query("""
    SELECT *
    FROM products
    WHERE name = :name
    LIMIT 1
""")
    suspend fun getProductByName(
        name: String
    ): Product?

    @Query("""
    SELECT COUNT(*)
    FROM products
    WHERE is_active = 1
""")
    fun getProductCount(): LiveData<Int>


}