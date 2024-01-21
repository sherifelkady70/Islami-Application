package com.route.islamyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.route.islamyapplication.databinding.ActivityMainBinding
import com.route.islamyapplication.fragment.AhadethFragment
import com.route.islamyapplication.fragment.QuranFragment
import com.route.islamyapplication.fragment.tasbehFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val tasbehFragment = tasbehFragment()
    val quranFragment = QuranFragment()
    val hadethFragment = AhadethFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setOnItemSelectedListener {
            if(it.itemId == R.id.quran_icon ){
                quran_Fragment()
            }else if(it.itemId==R.id.sebha_icon){
                tasbeh_Fragment()
            }else if (it.itemId==R.id.hadeth_icon){
                ahadeth_Fragment()
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun tasbeh_Fragment(){
        replaceFragment(tasbehFragment)
    }
    private fun quran_Fragment(){
        replaceFragment(quranFragment)
    }
    private fun ahadeth_Fragment(){
        replaceFragment(hadethFragment)
    }
    private fun replaceFragment(fragment : Fragment) {
        val transacrtion = supportFragmentManager.beginTransaction()
        transacrtion.replace(R.id.fragmentcontainer,fragment)
        transacrtion.commit()
    }
}