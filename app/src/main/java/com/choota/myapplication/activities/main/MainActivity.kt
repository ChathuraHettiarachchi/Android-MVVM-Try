package com.choota.myapplication.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.choota.myapplication.R
import com.choota.myapplication.adapters.BlogAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null
    private var blogAdapter: BlogAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(MainViewModel::class.java)

        swipeRefresh?.setOnRefreshListener { populateBlogs() }
        populateBlogs()
    }

    private fun populateBlogs() {
        mainViewModel?.let {
            it.allBlogs.observe(this,  Observer { data ->
                swipeRefresh?.isRefreshing = false
                blogAdapter = BlogAdapter(data)

                recyclerView?.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = blogAdapter
                }
            })
        }
    }
}
