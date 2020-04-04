package com.finalcad.recyclerviewheaderplayground.mergeadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import com.finalcad.recyclerviewheaderplayground.R
import com.finalcad.recyclerviewheaderplayground.common.ListItemAdapter
import com.finalcad.recyclerviewheaderplayground.common.ListViewModel

class MergeAdapterActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merge_adapter)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            val myLayoutManager = LinearLayoutManager(this@MergeAdapterActivity)
            layoutManager = myLayoutManager
            addItemDecoration(
                DividerItemDecoration(
                    this@MergeAdapterActivity,
                    myLayoutManager.orientation
                )
            )
        }

        val headerView = LayoutInflater.from(this)
            .inflate(R.layout.header_view, findViewById(R.id.recycler_view), false)
        val headerAdapter = HeaderViewAdapter(headerView)

        val simpleAdapter = ListItemAdapter(LayoutInflater.from(this))

        val mergeAdapter = MergeAdapter(headerAdapter, simpleAdapter)

        recyclerView.adapter = mergeAdapter

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        viewModel.header.observe(this, Observer { (headerView as? TextView)?.text = it })
        viewModel.items.observe(this, Observer { simpleAdapter.submitList(it) })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.original -> true.also { viewModel.original() }
        R.id.filtered -> true.also { viewModel.filterOriginal() }
        R.id.start -> true.also { viewModel.startOriginal() }
        R.id.empty -> true.also { viewModel.empty() }
        else -> super.onOptionsItemSelected(item)
    }
}
