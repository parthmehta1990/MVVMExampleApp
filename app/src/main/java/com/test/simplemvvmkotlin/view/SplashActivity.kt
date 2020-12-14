package com.test.simplemvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.simplemvvmkotlin.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}