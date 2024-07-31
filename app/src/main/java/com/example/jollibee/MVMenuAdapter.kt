package com.example.jollibee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.CartBinding

class MVMenuAdapter(
    private var items: MutableList<Data>,
    private val onQuantityChanged: (MutableList<Data>) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]
        holder.bind(data) {

            notifyDataSetChanged()
            onQuantityChanged(items)
        }
    }

    override fun getItemCount(): Int = items.size

    fun getItems(): MutableList<Data> = items
}
