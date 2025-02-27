package com.example.jollibee

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jollibee.databinding.FragmentOrderBinding

class Order : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: MVMenuAdapter
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        try {
            setupRecyclerView()
            updateTotals()
        } catch (e: Exception) {
            Log.e("OrderFragment", "Error setting up RecyclerView or updating totals", e)
        }

        binding.placeOrderButton.setOnClickListener {
            try {
                showConfirmationDialog()
            } catch (e: Exception) {
                Log.e("OrderFragment", "Error navigating to receipt", e)
            }
        }
        binding.addmoreButton.setOnClickListener{
            findNavController().navigate(R.id.home2)
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        try {
            val actualData = orderViewModel.orderList

            adapter = MVMenuAdapter(actualData, {updateTotals()}, {item->
                if (item.quantity <= 0)

                orderViewModel.orderList.remove(item)

            })

            binding.cartList.layoutManager = GridLayoutManager(context, 1)
            binding.cartList.adapter = adapter
        } catch (e: Exception) {
            Log.e("OrderFragment", "Error setting up RecyclerView", e)
        }
    }

    private fun updateTotals() {
        try {
            val items = (binding.cartList.adapter as? MVMenuAdapter)?.getItems() ?: return

            val totalItems = items.sumOf { it.quantity }
            val subtotal = items.sumOf { it.price * it.quantity }
            val total = subtotal

            Log.d("OrderFragment", "Total Items: $totalItems")
            Log.d("OrderFragment", "Subtotal: $subtotal")
            Log.d("OrderFragment", "Total: $total")

            binding.detailsTotalItemsValue.text = totalItems.toString()
            binding.detailsSubtotalValue.text = subtotal.toString()
            binding.detailsTotalValue.text = total.toString()
        } catch (e: Exception) {
            Log.e("OrderFragment", "Error updating totals", e)
        }
    }
    private fun showConfirmationDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setTitle("Confirm Order")
        dialogBuilder.setMessage("Are you sure you want to proceed?")
        dialogBuilder.setPositiveButton("Yes") { _, _ ->
            try {
                findNavController().navigate(R.id.reciept)
            } catch (e: Exception) {
                Log.e("OrderFragment", "Error navigating to receipt", e)
            }
        }
        dialogBuilder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        dialogBuilder.create().show()
    }
}

