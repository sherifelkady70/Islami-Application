package com.route.islamyapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamyapplication.models.HadethModel
import com.route.islamyapplication.databinding.NameOfHadethItemsBinding

class HadethAdapter(val myList : MutableList<HadethModel>) : RecyclerView.Adapter<HadethAdapter.ViewHolder>(){

    class ViewHolder(val binding : NameOfHadethItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = NameOfHadethItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : HadethModel = myList[position]
        holder.binding.nameofhadeth.text = data.title
        if(onHadethClick!=null) {
            holder.itemView.setOnClickListener {
                onHadethClick!!.onItemClick(data,position)
            }
        }
    }
    var onHadethClick : onItemClickListener?=null
    interface onItemClickListener {
        fun onItemClick(nameOfHadeth : HadethModel, position: Int )
    }
}