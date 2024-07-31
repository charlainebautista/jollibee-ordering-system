package com.example.jollibee

import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.CartBinding

class ViewHolder(private val binding: CartBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Data, observer : (data: Data) -> Unit, onQuantityChanged: (Data) -> Unit)
     {

            binding.orderName.text = data.name
            binding.orderPrice.text = data.price.toString()
            binding.cartQuantity.text = data.quantity.toString()
            binding.orderimage.setImageResource(data.imageResId)


        binding.addButton.setOnClickListener {
            data.quantity += 1
            binding.cartQuantity.text = data.quantity.toString()
            onQuantityChanged(data)
            observer.invoke(data)

        }

        binding.removeButton.setOnClickListener {
            if (data.quantity > 0) {
                data.quantity -= 1
                binding.cartQuantity.text = data.quantity.toString()
                onQuantityChanged(data)
                observer.invoke(data)

            }
        }
    }
}
