package com.route.islamyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.route.islamyapplication.fragment.tasbehFragment

class MainActivity : AppCompatActivity() {
    val tasbehFragment = tasbehFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tasbeh_Fragment()
    }

    private fun tasbeh_Fragment(){
        addFragment(tasbehFragment)
    }
    private fun addFragment(fragment : Fragment) {
        val transacrtion = supportFragmentManager.beginTransaction()
        transacrtion.add(R.id.fragmentcontainer,fragment)
        transacrtion.commit()
    }
}