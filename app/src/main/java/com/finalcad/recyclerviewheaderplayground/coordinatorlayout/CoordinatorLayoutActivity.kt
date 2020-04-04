package com.finalcad.recyclerviewheaderplayground.coordinatorlayout

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
import androidx.recyclerview.widget.RecyclerView
import com.finalcad.recyclerviewheaderplayground.R
import com.finalcad.recyclerviewheaderplayground.common.ListItemAdapter
import com.finalcad.recyclerviewheaderplayground.common.ListViewModel

class CoordinatorLayoutActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)
        val headerView = findViewById<TextView>(R.id.text_view)
        val simpleAdapter = ListItemAdapter(LayoutInflater.from(this))
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            val myLayoutManager = LinearLayoutManager(this@CoordinatorLayoutActivity)
            layoutManager = myLayoutManager
            addItemDecoration(DividerItemDecoration(this@CoordinatorLayoutActivity, myLayoutManager.orientation))
            adapter = simpleAdapter
        }

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        viewModel.header.observe(this, Observer { headerView.text = it })
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
        R.id.header_short -> true.also { viewModel.headerShort() }
        R.id.header_long -> true.also { viewModel.headerLong() }
        else -> super.onOptionsItemSelected(item)
    }
}
