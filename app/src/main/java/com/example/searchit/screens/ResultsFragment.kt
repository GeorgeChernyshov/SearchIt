package com.example.searchit.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.searchit.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentResultsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        return binding.root
    }
}