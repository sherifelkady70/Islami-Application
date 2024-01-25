package com.route.islamyapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.islamyapplication.Constants
import com.route.islamyapplication.R
import com.route.islamyapplication.databinding.ActivityHadethDetailsBinding

class HadethDetails : AppCompatActivity() {
    lateinit var binding : ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameOfHadethtxt.text = intent.getStringExtra(Constants.NAMEOFHADETHKEY)
        binding.contentHadeth.text = intent.getStringExtra(Constants.CONTENTOFHADETH)
    }
}