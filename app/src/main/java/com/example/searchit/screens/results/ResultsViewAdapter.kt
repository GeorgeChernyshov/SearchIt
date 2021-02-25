package com.example.searchit.screens.results

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchit.databinding.ResultViewItemBinding
import com.example.searchit.network.SearchResult

class ResultsViewAdapter: ListAdapter<SearchResult, ResultsViewAdapter.SearchResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class SearchResultViewHolder(private val binding: ResultViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {

    }
}