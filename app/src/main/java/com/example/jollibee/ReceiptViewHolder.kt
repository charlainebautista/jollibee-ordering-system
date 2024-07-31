package com.example.jollibee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.ItemsBinding

class ReceiptViewHolder(private val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Data) {
        binding.receiptItemName.text = data.name
        binding.receiptItemPrice.text = data.price.toString()
        binding.receiptItemQuantity.text = data.quantity.toString()
        binding.receiptItemImage.setImageResource(data.imageResId)
    }

    companion object {
        fun from(parent: ViewGroup): ReceiptViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemsBinding.inflate(layoutInflater, parent, false)
            return ReceiptViewHolder(binding)
        }
    }
}
