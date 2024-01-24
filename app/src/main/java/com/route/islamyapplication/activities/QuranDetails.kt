package com.route.islamyapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.route.islamyapplication.Constants
import com.route.islamyapplication.R
import com.route.islamyapplication.databinding.ActivityQuranDetailsBinding
import com.route.islamyapplication.databinding.FragmentQuranBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class QuranDetails : AppCompatActivity() {
    lateinit var binding: ActivityQuranDetailsBinding
    lateinit var file : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuranDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val nameOfSurah = intent.getStringExtra(Constants.NAMEKEY)
         file = intent.getStringExtra(Constants.NAMEOFFILEKEY)!!
        binding.nameOfSurahtxt.text=nameOfSurah
        binding.contentSurah.text = readFromFile()

    }

    private fun readFromFile() : String{
        var fileString = " "
        try  {
        val inputStream = assets.open(file)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val fileLines : List<String> = reader.readLines()
         fileString = fileLines.joinToString(" ") { line ->
            val index = fileLines.indexOf(line) +1
            return@joinToString line+" (${index}) "
        }
            Log.d("readFromFile", fileString)
            inputStream.close()
        } catch (e:Exception){
            e.printStackTrace()
        }
        return fileString
    }
}