package com.riceup.riceapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riceup.riceapp.R
import com.riceup.riceapp.models.Category

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    // ViewHolder untuk setiap item dalam RecyclerView
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
        val categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryName.text = category.name

        // Memuat gambar menggunakan Glide
        Glide.with(holder.itemView.context)
            .load(category.imageUrl) // URL gambar kategori
            .placeholder(R.drawable.ic_placeholder) // Gambar sementara jika URL kosong
            .error(R.drawable.ic_placeholder) // Gambar jika URL tidak valid
            .into(holder.categoryImage)
    }

    override fun getItemCount(): Int = categories.size
}
