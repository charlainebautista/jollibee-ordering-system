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
            val data = Data(imageResId = R.drawable.onechickenjoy, name = "1pc Chickenjoy Solo", price = 99, quantity = 1)

            if (orderViewModel.exists(data)){
                val index = orderViewModel.orderList.indexOfFirst { it.name == data.name }
                orderViewModel.orderList[index].quantity +=1
            }else{
                orderViewModel.orderList.add(data)
            }

            findNavController().navigate(R.id.order)
        }
        binding.orderc2Button.setOnClickListener {
            val data = Data(imageResId = R.drawable.twochicken, name = "2pc Chickenjoy Solo", price = 195, quantity = 1)

            if (orderViewModel.exists(data)){
                val index = orderViewModel.orderList.indexOfFirst { it.name == data.name }
                orderViewModel.orderList[index].quantity +=1
            }else{
                orderViewModel.orderList.add(data)
            }

            findNavController().navigate(R.id.order)
        }

        binding.orderc3Button.setOnClickListener {
            val data = Data(imageResId = R.drawable.chickenandburger, name = "1pc Chickenjoy w/ Burger Steak", price = 139, quantity = 1)

            if (orderViewModel.exists(data)){
                val index = orderViewModel.orderList.indexOfFirst { it.name == data.name }
                orderViewModel.orderList[index].quantity +=1
            }else{
                orderViewModel.orderList.add(data)
            }

            findNavController().navigate(R.id.order)
        }

        binding.orderc4Button.setOnClickListener {
            val data = Data(imageResId = R.drawable.chickenandfries, name = "1pc Chickenjoy w/ Fries", price = 129, quantity = 1)

            if (orderViewModel.exists(data)){
                val index = orderViewModel.orderList.indexOfFirst { it.name == data.name }
                orderViewModel.orderList[index].quantity +=1
            }else{
                orderViewModel.orderList.add(data)
            }

            findNavController().navigate(R.id.order)
        }

        binding.orderc5Button.setOnClickListener {
            val data = Data(imageResId = R.drawable.chickenfloat, name = "1pc Chickenjoy w/ Coke Float", price = 149, quantity = 1)

            if (orderViewModel.exists(data)){
                val index = orderViewModel.orderList.indexOfFirst { it.name == data.name }
                orderViewModel.orderList[index].quantity +=1
            }else{
                orderViewModel.orderList.add(data)
            }

            findNavController().navigate(R.id.order)
        }

        binding.orderc6Button.setOnClickListener {
            val data = Data(imageResId = R.drawable.chickenpalabok, name = "1pc Chickenjoy w/ Palabok", price = 129, quantity = 1)

            if (orderViewModel.exists(data)){
                val index = orderViewModel.orderList.indexOfFirst { it.name == data.name }
                orderViewModel.orderList[index].quantity +=1
            }else{
                orderViewModel.orderList.add(data)
            }

            findNavController().navigate(R.id.order)
        }




        return binding.root
    }


}