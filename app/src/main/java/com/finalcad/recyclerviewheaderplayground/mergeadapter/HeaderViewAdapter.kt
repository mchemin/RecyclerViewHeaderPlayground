package com.finalcad.recyclerviewheaderplayground.mergeadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HeaderViewAdapter(private val view: View): RecyclerView.Adapter<HeaderViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HeaderViewAdapter.ViewHolder(view)

    override fun onBindViewHolder(holder: HeaderViewAdapter.ViewHolder, position: Int) = Unit
}