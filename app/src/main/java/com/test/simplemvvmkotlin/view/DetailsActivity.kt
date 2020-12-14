package com.test.simplemvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.simplemvvmkotlin.R
import com.test.simplemvvmkotlin.viewModel.DetailsActivityViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        detailViewModel = ViewModelProvider(this).get(DetailsActivityViewModel::class.java)

        if (intent.hasExtra("name")) {
            tv_location.text = intent.getStringExtra("name")

        }

        if (intent.hasExtra("Location")) {
            //Do the API Call here and
            //checking that if viewmodel response is not null then we will not call the API again even on configuration change
            if (intent.getIntExtra("Location",0) != 0 && detailViewModel.response.value==null)
                detailViewModel.getWeather(intent.getIntExtra("Location",0)!!)
        }

        detailViewModel.showProgress.observe(this, Observer {

            if(it){
                details_progress.visibility=View.VISIBLE
            }else{
                details_progress.visibility=View.GONE
            }
        })

        detailViewModel.response.observe(this, Observer {

            if(it!=null){
                tv_temp.text=it.consolidated_weather[0].the_temp.toString()
            }

        })
    }
}