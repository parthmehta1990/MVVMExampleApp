package com.test.simplemvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.simplemvvmkotlin.R
import com.test.simplemvvmkotlin.adapter.LocationAdapter
import com.test.simplemvvmkotlin.viewModel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    //creating variable for viewmodel
    private lateinit var viewModel: SearchActivityViewModel

    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel = ViewModelProvider(this).get(SearchActivityViewModel::class.java)

        //onclick of search we call a function on viewmodel
        im_search.setOnClickListener {
            if (tv_search.text.toString().isNotEmpty())
                viewModel.searchLocation(tv_search.text.toString())
        }

        viewModel.showProgress.observe(this, Observer {
            if (it) {
                search_progress.visibility = View.VISIBLE
            } else {
                search_progress.visibility = View.GONE
            }
        })

        viewModel.locationList.observe(this, Observer {

            adapter.setLocationList(it)

        })

        adapter = LocationAdapter(this)
        rv_search.adapter = adapter

    }
}