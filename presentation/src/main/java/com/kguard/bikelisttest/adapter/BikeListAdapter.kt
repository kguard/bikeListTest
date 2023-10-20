package com.kguard.bikelisttest.adapter

import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kguard.bikelisttest.databinding.ItemBikeListBinding
import com.kguard.domain.model.DomainBikeList

class BikeListAdapter() : RecyclerView.Adapter<BikeListAdapter.BikeListViewHolder>() {
    private var bikeList : List<DomainBikeList> = ArrayList()
    inner class BikeListViewHolder(private val binding: ItemBikeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setItem(bike : DomainBikeList){
            binding.bike = bike
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BikeListViewHolder {
        val binding = ItemBikeListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BikeListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return bikeList?.size ?: 10
    }

    override fun onBindViewHolder(holder: BikeListViewHolder, position: Int) {
        bikeList?.get(position)?.let { holder.setItem(it) }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newBikeList: List<DomainBikeList>){
        bikeList = newBikeList
        notifyDataSetChanged()
    }
}