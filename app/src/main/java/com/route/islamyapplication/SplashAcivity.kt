package com.route.islamyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.route.islamyapplication.activities.MainActivity

class SplashAcivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_acivity)

        Handler().postDelayed(object : Runnable{
            override fun run() {
               startMainActivity()
            }

        },2000)
    }

    private fun startMainActivity(){
        val intent = Intent(this@SplashAcivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}