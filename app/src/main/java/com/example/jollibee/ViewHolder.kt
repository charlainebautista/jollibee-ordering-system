package com.example.jollibee

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.CartBinding

class ViewHolder (private var binding : CartBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data:Data, onDataClick:(data:Data)-> Unit){
        binding.orderName.text = data.name
        binding.orderPrice.text = data.price.toString()
        binding.cartQuantity.text = data.quantity.toString()


        binding.removeButton.setOnClickListener{
                if (data.quantity > 0) {
                    data.quantity-- }
                binding.cartQuantity.text = data.quantity.toString()}
        binding.addButton.setOnClickListener{ data.quantity++
                binding.cartQuantity.text = data.quantity.toString()
            }



        itemView.setOnClickListener{onDataClick.invoke(data)}
    }

}