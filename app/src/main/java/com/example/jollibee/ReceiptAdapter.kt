package com.example.jollibee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.ItemsBinding

class ReceiptAdapter(
    private var items: List<Data>
) : RecyclerView.Adapter<ReceiptAdapter.ReceiptViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceiptViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReceiptViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReceiptViewHolder, position: Int) {
        val data = items[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = items.size

    class ReceiptViewHolder(private val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.receiptItemName.text = data.name
            binding.receiptItemPrice.text = data.price.toString()
            binding.receiptItemQuantity.text = data.quantity.toString()
            binding.receiptItemImage.setImageResource(data.imageResId)
        }
    }
}
