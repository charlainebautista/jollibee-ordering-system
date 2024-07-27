package com.example.jollibee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jollibee.databinding.FragmentOrderBinding


class Order : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var listAdapter : Adapter
    private var dataset = mutableListOf<Data>()
    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentOrderBinding.inflate(inflater, container, false)
        listAdapter = Adapter(dataset, {})
        dataset.add(Data(name = "Lorem Ipsum", price = 99))
        dataset.add(Data(name = "Lorem Ipsum dolor sit amet", price = 99))
        listAdapter.notifyDataSetChanged()
        binding.cartList.adapter = listAdapter


        return binding.root
    }


}