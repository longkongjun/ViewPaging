package com.pusu.viewpaging.adapter.fixedsize

import androidx.paging.PagingSource
import androidx.paging.PagingSourceFactory
import com.pusu.viewpaging.page.PageMeasurer
import com.pusu.viewpaging.viewmodel.Flower

class FixedFlowerPageSourceFactory(private val measurer: PageMeasurer) : PagingSourceFactory<Int, Flower> {

    override fun invoke(): PagingSource<Int, Flower> {
        return FixedFlowerPageSource(measurer)
    }

}