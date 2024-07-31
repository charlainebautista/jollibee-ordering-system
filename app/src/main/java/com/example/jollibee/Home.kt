package com.example.jollibee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.jollibee.databinding.FragmentHomeBinding


class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var orderViewModel: OrderViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.orderc1Button.setOnClickListener{
            findNavController().navigate(R.id.order)
            orderViewModel.orderList.add(Data(  imageResId = R.drawable.onechickenjoy, name = "1pc Chickenjoy Solo", price = 99, quantity = 1))
        }
        binding.orderc2Button.setOnClickListener {
            findNavController().navigate(R.id.order)
            orderViewModel.orderList.add(Data(  imageResId = R.drawable.twochicken, name = "2pc Chickenjoy Solo", price = 195, quantity = 1))
        }
        binding.orderc3Button.setOnClickListener {
            findNavController().navigate(R.id.order)
            orderViewModel.orderList.add(Data(  imageResId = R.drawable.chickenandburger, name = "1pc Chickenjoy w/ Burger Steak", price = 139, quantity = 1))
        }
        binding.orderc4Button.setOnClickListener {
            findNavController().navigate(R.id.order)
            orderViewModel.orderList.add(Data(  imageResId = R.drawable.chickenandfries, name = "1pc Chickenjoy w/ Fries", price = 129, quantity = 1))
        }




        return binding.root
    }


}