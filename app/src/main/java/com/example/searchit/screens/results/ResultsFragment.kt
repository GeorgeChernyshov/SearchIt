package com.example.searchit.screens.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.searchit.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private lateinit var viewModel: ResultsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentResultsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(ResultsViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSearchResults()
    }
}