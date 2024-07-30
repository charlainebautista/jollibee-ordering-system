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
            orderViewModel.orderList.add(Data( name = "Lorem Ipsum", price = 99, quantity = 1))
        }




        return binding.root
    }


}