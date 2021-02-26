package com.example.searchit.screens.results

import android.content.Intent
import android.net.NetworkRequest
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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

        val query = ResultsFragmentArgs.fromBundle(requireArguments()).request
        val viewModelFactory = ResultsViewModelFactory(query?: "")
        viewModel = ViewModelProvider(this, viewModelFactory).get(ResultsViewModel::class.java)
        binding.viewModel = viewModel

        val adapter = ResultsViewAdapter(ResultViewListener {  url ->
            val webpage: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        })
        binding.searchResults.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSearchResults()
    }
}