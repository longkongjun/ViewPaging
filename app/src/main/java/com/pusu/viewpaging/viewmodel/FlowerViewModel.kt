package com.pusu.viewpaging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlowerViewModel : ViewModel() {

    private val _flowers = MutableLiveData<List<Flower>>()
    val flowers: LiveData<List<Flower>> = _flowers

    fun queryFlowers() {
        flowerNames.mapIndexed { index, name ->
            Flower(index, name)
        }.let {
            _flowers.postValue(it.shuffled())
        }
    }
}