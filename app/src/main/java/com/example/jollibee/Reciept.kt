package com.example.jollibee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jollibee.databinding.FragmentRecieptBinding

class Reciept : Fragment() {

    private lateinit var binding: FragmentRecieptBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecieptBinding.inflate(inflater, container, false)

        setupRecyclerView()

        binding.orderAgainButton.setOnClickListener {
            findNavController().navigate(R.id.home2)
        }


        return binding.root
    }

    private fun setupRecyclerView() {
        // Sample data, replace with actual data
        val actualData = listOf(
            Data(name = "Item 2", price = 10, quantity = 1, imageResId = R.drawable.chickenandburger),
            Data(name = "Item 2", price = 20, quantity = 2, imageResId = R.drawable.chickenspag)
        )



        val adapter = ReceiptAdapter(actualData)
        binding.receiptItems.layoutManager = GridLayoutManager(context, 1) // Single column
        binding.receiptItems.adapter = adapter


        binding.receiptNumitemsText.text = actualData.size.toString()
        val totalPrice = actualData.sumOf { it.price }
        binding.receiptmasterText.text = totalPrice.toString()
    }
}
