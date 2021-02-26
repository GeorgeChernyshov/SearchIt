package com.example.searchit

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchit.network.SearchResult
import com.example.searchit.screens.results.ResultsViewAdapter

@BindingAdapter("bind:titleBinding")
fun TextView.bindTitle(item: SearchResult?) {
    item?.let {
        text = item.title
    }
}

@BindingAdapter("bind:snippetBinding")
fun TextView.bindSnippet(item: SearchResult?) {
    item?.let {
        text = item.snippet
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<SearchResult>?) {
    val adapter = recyclerView.adapter as ResultsViewAdapter
    adapter.submitList(data)
}