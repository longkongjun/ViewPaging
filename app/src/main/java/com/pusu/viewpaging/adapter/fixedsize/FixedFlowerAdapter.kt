package com.pusu.viewpaging.adapter.fixedsize

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pusu.viewpaging.databinding.ItemFlowerFixedBinding
import com.pusu.viewpaging.viewmodel.Flower
import com.pusu.viewpaging.viewmodel.FlowerDiff

class FixedFlowerAdapter : ListAdapter<Flower, FixedFlowerHolder>(FlowerDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixedFlowerHolder {
        return ItemFlowerFixedBinding.inflate(LayoutInflater.from(parent.context), parent, false).let {
            FixedFlowerHolder(it)
        }
    }

    override fun onBindViewHolder(holder: FixedFlowerHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }

    override fun onBindViewHolder(holder: FixedFlowerHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        Log.d("FixedFlowerAdapter", "onBindViewHolder with payloads: $position - $payloads")
    }

}

class FixedFlowerHolder(private val binding: ItemFlowerFixedBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Flower, position: Int) {
        binding.root.text = "第${position + 1}页:${item.name}"
    }

}