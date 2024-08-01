package com.pusu.viewpaging.page.fixedsize

import android.util.Size
import com.pusu.viewpaging.page.PageMeasurer
import com.pusu.viewpaging.page.PageModel
import com.pusu.viewpaging.viewmodel.Flower
import com.pusu.viewpaging.viewmodel.flowerNames

class FlowerFixedSizePageModel(private val measurer: PageMeasurer) : PageModel<List<Flower>> {

    private val measureCache = mutableMapOf<Int, Size>()

    private val flowers = flowerNames.mapIndexed { index, name ->
        Flower(index, name)
    }.shuffled()

    override fun loadPage(page: Int): Result<List<Flower>> {
        TODO("Not yet implemented")
    }

    private fun measurePage(page: Int): Size {
        return measureCache[page] ?: measurer.invoke(page).also {
            measureCache[page] = it
        }
    }

}