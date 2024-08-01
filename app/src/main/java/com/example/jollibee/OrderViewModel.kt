package com.example.jollibee

import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel(){
    var orderList = mutableListOf<Data>()

    fun exists(item: Data):Boolean{
        return orderList.any{it.name == item.name} ?:false
    }
}