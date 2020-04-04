package com.finalcad.recyclerviewheaderplayground.common

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textView1: TextView = view.findViewById(android.R.id.text1)
    private val textView2: TextView = view.findViewById(android.R.id.text2)

    fun bind(item: String) {
        textView1.text = item
        textView2.text = "Position $adapterPosition"
    }
}