package com.example.jollibee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jollibee.databinding.FragmentRecieptBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Receipt : Fragment() {

    private lateinit var orderViewModel: OrderViewModel
    private lateinit var binding: FragmentRecieptBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecieptBinding.inflate(inflater, container, false)


        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]
        setupRecyclerView()

        binding.orderAgainButton.setOnClickListener {
            orderViewModel.orderList.clear()
            findNavController().navigate(R.id.home2)
        }

        val date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val currentDate = date.format(Date())
        binding.receiptdateText.text = currentDate.toString()
        return binding.root
    }

    private fun setupRecyclerView() {

        val adapter = ReceiptAdapter(orderViewModel.orderList)
        binding.receiptItems.adapter = adapter




        binding.receiptNumitemsText.text = orderViewModel.orderList.size.toString()
        val totalPrice = orderViewModel.orderList.sumOf { it.price * it.quantity }
        binding.receiptmasterTotalText.text = "$totalPrice"
    }
}
