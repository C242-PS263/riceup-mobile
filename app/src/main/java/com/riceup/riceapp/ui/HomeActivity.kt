package com.riceup.riceapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.riceup.riceapp.adapters.CategoryAdapter
import com.riceup.riceapp.databinding.ActivityHomeBinding
import com.riceup.riceapp.models.MainViewModel


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe data
        mainViewModel.categories.observe(this) { categories ->
            // Update RecyclerView adapter with categories
            binding.recyclerView.adapter = CategoryAdapter(categories)
        }

        mainViewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }

        // Fetch categories from API
        mainViewModel.fetchCategories()
    }
}