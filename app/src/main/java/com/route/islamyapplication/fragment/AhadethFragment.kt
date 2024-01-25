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
import com.route.islamyapplication.models.HadethModel
import com.route.islamyapplication.R
import com.route.islamyapplication.activities.HadethDetails
import com.route.islamyapplication.adapters.HadethAdapter
import com.route.islamyapplication.databinding.FragmentAhadethBinding
import java.io.BufferedReader
import java.io.InputStreamReader


class AhadethFragment : Fragment() {
    lateinit var binding : FragmentAhadethBinding
    lateinit var adapter : HadethAdapter
    var hadethListModel = mutableListOf<HadethModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        inflater.inflate(R.layout.fragment_ahadeth, container, false)
        binding= FragmentAhadethBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadethFile()
        prepareRV()
    }

    private fun prepareRV(){
        adapter= HadethAdapter(hadethListModel)
        adapter.onHadethClick = object :HadethAdapter.onItemClickListener {
            override fun onItemClick(nameOfHadeth: HadethModel, position: Int) {
                val intent = Intent(requireContext(),HadethDetails::class.java)
                intent.putExtra(Constants.NAMEOFHADETHKEY,nameOfHadeth.title)
                intent.putExtra(Constants.CONTENTOFHADETH,nameOfHadeth.content)
                startActivity(intent)
            }
        }
        binding.ahadethRV.layoutManager= LinearLayoutManager(activity)
        binding.ahadethRV.adapter=adapter
    }

    private fun readAhadethFile(){
        try {
            val inputStream = activity?.assets?.open("ahadeeth.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val allHadethContent = reader.readText() //read all file as a one text
            val hadethContentList: List<String> = allHadethContent.split("#")//split to items in list based on #
            for (hadeth: String in hadethContentList) {
                val trimHadeth = hadeth.trim() //to remove all spaces
                val singleHadethLines : MutableList<String> = trimHadeth.split("\n").toMutableList() //to split each item to lines
                val titleOfHadeth = singleHadethLines[0]//save title from each item in list
               singleHadethLines.removeAt(0)//remove title from each item in list
                val contentOfHadeth = singleHadethLines.joinToString(" ") {
                    return@joinToString it
                }
                    hadethListModel.add(HadethModel(titleOfHadeth, contentOfHadeth))
                Log.e("readAhadethFile","${titleOfHadeth} , ${contentOfHadeth}")
            }
        }catch (e:Exception){
            e.printStackTrace()
            Log.e("readAhadethFile","${e.printStackTrace()}")
        }

    }
}