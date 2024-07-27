package com.example.jollibee

import androidx.recyclerview.widget.RecyclerView
import com.example.jollibee.databinding.CartBinding

class ViewHolder (private var binding : CartBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data:Data, onDataClick:(data:Data)-> Unit){
        binding.orderName.text = data.name
        binding.orderPrice.text = data.price.toString()


        itemView.setOnClickListener{onDataClick.invoke(data)}
    }

}