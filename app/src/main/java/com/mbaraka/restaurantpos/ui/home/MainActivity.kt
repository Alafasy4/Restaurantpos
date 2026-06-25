package com.mbaraka.restaurantpos.ui.home

import androidx.activity.viewModels
import com.mbaraka.restaurantpos.viewmodel.DashboardViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mbaraka.restaurantpos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dashboardViewModel: DashboardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupClicks()
        observeDashboard()
    }

    private fun observeDashboard() {
        dashboardViewModel.totalProducts.observe(this) { count ->
            binding.txtProductsCount.text = count.toString()
        }

        dashboardViewModel.totalSales.observe(this) { count ->
            binding.txtSalesCount.text = count.toString()
        }

        dashboardViewModel.lowStockProducts.observe(this) { products ->
            binding.txtLowStock.text = products.size.toString()
        }
    }

    private fun setupClicks() {

        binding.cardProducts.setOnClickListener {

            // TODO:
            // Open Product Screen

        }

        binding.cardSales.setOnClickListener {

            // TODO:
            // Open Sales Screen

        }

        binding.cardReports.setOnClickListener {

            // TODO:
            // Open Reports Screen

        }

        binding.cardStock.setOnClickListener {

            // TODO:
            // Open Stock Screen

        }

    }

}