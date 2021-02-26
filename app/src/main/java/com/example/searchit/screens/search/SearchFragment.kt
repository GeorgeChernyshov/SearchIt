package com.example.searchit.screens.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.searchit.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSearchBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.searchButton.setOnClickListener {
            it?.let {
                findNavController().navigate(SearchFragmentDirections
                    .actionSearchFragmentToResultsFragment(binding.searchBar.text.toString()))
            }
        }

        return binding.root
    }
}