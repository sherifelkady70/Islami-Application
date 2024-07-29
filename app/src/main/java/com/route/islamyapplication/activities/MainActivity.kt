package com.route.islamyapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.route.islamyapplication.R
import com.route.islamyapplication.databinding.ActivityMainBinding
import com.route.islamyapplication.fragment.AhadethFragment
import com.route.islamyapplication.fragment.QuranFragment
import com.route.islamyapplication.fragment.SebhaFragment
import com.route.islamyapplication.radio.RadioFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val SebhaFragment = SebhaFragment()
    val quranFragment = QuranFragment()
    val hadethFragment = AhadethFragment()
    val radioFragment = RadioFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addQuranFragment()
        binding.navView.setOnItemSelectedListener {
            if(it.itemId == R.id.quran_icon){
                quran_Fragment()
            }else if(it.itemId== R.id.sebha_icon){
                tasbeh_Fragment()
            }else if (it.itemId== R.id.hadeth_icon){
                ahadeth_Fragment()
            }else if(it.itemId==R.id.radio_icon){
                radio_Fragment()
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun addQuranFragment(){
        addFragment(quranFragment)
    }
    private fun tasbeh_Fragment(){
        replaceFragment(SebhaFragment)
    }
    private fun quran_Fragment(){
        replaceFragment(quranFragment)
    }
    private fun ahadeth_Fragment(){
        replaceFragment(hadethFragment)
    }
    private fun radio_Fragment(){
        replaceFragment(radioFragment)
    }
    private fun replaceFragment(fragment : Fragment) {
        val transacrtion = supportFragmentManager.beginTransaction()
        transacrtion.replace(R.id.fragmentcontainer,fragment)
        transacrtion.commit()
    }
    private fun addFragment(fragment : Fragment) {
        val transacrtion = supportFragmentManager.beginTransaction()
        transacrtion.add(R.id.fragmentcontainer,fragment)
        transacrtion.commit()
    }
}