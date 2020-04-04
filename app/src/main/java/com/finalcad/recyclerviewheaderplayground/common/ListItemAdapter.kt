package com.finalcad.recyclerviewheaderplayground.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem === newItem
    override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
}

class ListItemAdapter(private val layoutInflater: LayoutInflater) : ListAdapter<String, ListItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListItemViewHolder(
        layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
    )

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}