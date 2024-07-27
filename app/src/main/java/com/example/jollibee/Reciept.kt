package com.example.jollibee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jollibee.databinding.CartBinding
import com.example.jollibee.databinding.FragmentRecieptBinding

class Reciept : Fragment() {

    private lateinit var binding: FragmentRecieptBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecieptBinding.inflate(inflater, container, false)




        return binding.root
    }



}