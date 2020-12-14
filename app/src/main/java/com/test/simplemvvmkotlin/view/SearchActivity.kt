package com.test.simplemvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.simplemvvmkotlin.R
import com.test.simplemvvmkotlin.viewModel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    //creating variable for viewmodel
    lateinit var viewModel:SearchActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel=ViewModelProvider(this).get(SearchActivityViewModel::class.java)

        //onclick of search we call a function on viewmodel
        im_search.setOnClickListener {

        }

        viewModel.showProgress.observe(this, Observer {

        })
    }
}