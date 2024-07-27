package com.pusu.viewpaging.viewmodel

import androidx.recyclerview.widget.DiffUtil

object FlowerDiff : DiffUtil.ItemCallback<Flower>() {

    override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem.name == newItem.name
    }
}