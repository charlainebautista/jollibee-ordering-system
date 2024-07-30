package com.example.jollibee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.jollibee.databinding.FragmentOrderBinding


class Order : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var listAdapter : MVMenuAdapter
    private lateinit var orderViewModel: OrderViewModel
    private var dataset = mutableListOf<Data>()
    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentOrderBinding.inflate(inflater, container, false)
        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]
        listAdapter = MVMenuAdapter(orderViewModel.orderList, {})

        listAdapter.notifyDataSetChanged()
        binding.cartList.adapter = listAdapter

        binding.placeOrderButton.setOnClickListener{findNavController().navigate(R.id.reciept)}


        return binding.root
    }


}