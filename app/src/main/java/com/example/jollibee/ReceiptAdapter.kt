package com.example.jollibee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.ItemsBinding

class ReceiptAdapter(
    private val items: List<Data>
) : RecyclerView.Adapter<ReceiptAdapter.ReceiptViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceiptViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReceiptViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReceiptViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ReceiptViewHolder(private val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.receiptItemName.text = data.name
            binding.receiptItemPrice.text = data.price.toString()
            binding.receiptItemQuantity.text = data.quantity.toString()
            binding.receiptItemImage.setImageResource(data.imageResId)
        }
    }
}
