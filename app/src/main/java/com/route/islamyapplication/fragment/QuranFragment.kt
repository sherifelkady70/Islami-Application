package com.route.islamyapplication.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.route.islamyapplication.Constants
import com.route.islamyapplication.models.SurahandAyat
import com.route.islamyapplication.activities.QuranDetails
import com.route.islamyapplication.adapters.QuranAdapter
import com.route.islamyapplication.databinding.FragmentQuranBinding


class QuranFragment : Fragment() {
    lateinit var binding : FragmentQuranBinding
    lateinit var quranAdapter: QuranAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuranBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prapareRV()

    }

    private fun prapareRV(){
        quranAdapter= QuranAdapter(Constants.NAMESANDNUMBEROFAYAT)
        quranAdapter.onSurahClick = object : QuranAdapter.onItemClickListener{
            override fun onItemClick(content: SurahandAyat, position: Int) {
                val intent = Intent(activity,QuranDetails::class.java)
                intent.putExtra(Constants.NAMEOFFILEKEY,"${position+1}.txt")
                val contentOfFile = "${position+1}.txt"
                Log.d("QuranFragment","the content of files : $contentOfFile")
                intent.putExtra(Constants.NAMEKEY,content.name)
                startActivity(intent)
            }

        }
        binding.rvItems.layoutManager=LinearLayoutManager(activity)
        binding.rvItems.adapter=quranAdapter
    }
}