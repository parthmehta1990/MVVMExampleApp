package com.test.simplemvvmkotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.test.simplemvvmkotlin.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            var intent = Intent(this@SplashActivity, SearchActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}