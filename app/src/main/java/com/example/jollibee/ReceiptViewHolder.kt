package com.example.jollibee

import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.ItemsBinding

class ReceiptViewHolder (private var binding : ItemsBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data:Data, onDataClick:(data:Data)-> Unit){
        binding.receiptItemName.text = data.name
        binding.receiptItemPrice.text = data.price.toString()

    }
}