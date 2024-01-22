package com.route.islamyapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamyapplication.SurahandAyat
import com.route.islamyapplication.databinding.NameAndAyatItemsBinding

class QuranAdapter (var myList : MutableList<SurahandAyat>) : RecyclerView.Adapter<QuranAdapter.ViewHolder>(){

    class ViewHolder(var  binding: NameAndAyatItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v  = NameAndAyatItemsBinding.inflate(LayoutInflater.from(parent.context)
           ,parent,false)
           return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : SurahandAyat = myList[position]
        holder.binding.namesofsurah.text = data.name
        holder.binding.numofayat.text=data.numberOfAyat.toString()
    }
}