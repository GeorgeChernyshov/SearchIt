package com.example.searchit.screens.results

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchit.R
import com.example.searchit.databinding.ResultViewItemBinding
import com.example.searchit.network.SearchResult

class ResultsViewAdapter(val clickListener: ResultViewListener): ListAdapter<SearchResult, ResultsViewAdapter.ViewHolder>(DiffCallback)  {

    companion object DiffCallback: DiffUtil.ItemCallback<SearchResult>() {
        override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem.link == newItem.link
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ResultViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ResultViewItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(clickListener: ResultViewListener, item: SearchResult) {
            binding.result = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }
}

class ResultViewListener(val clickListener: (url: String) -> Unit) {
    fun onClick(result: SearchResult) = clickListener(result.link)
}