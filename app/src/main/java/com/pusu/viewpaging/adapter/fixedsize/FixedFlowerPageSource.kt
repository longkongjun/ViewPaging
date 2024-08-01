package com.pusu.viewpaging.adapter.fixedsize

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pusu.viewpaging.page.PageMeasurer
import com.pusu.viewpaging.page.fixedsize.FlowerFixedSizePageModel
import com.pusu.viewpaging.viewmodel.Flower

class FixedFlowerPageSource(measurer: PageMeasurer) : PagingSource<Int, List<Flower>>() {

    private val model = FlowerFixedSizePageModel(measurer)

    override fun getRefreshKey(state: PagingState<Int, List<Flower>>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, List<Flower>> {
        val pageIndex = params.key ?: 0
        model.loadPage(pageIndex).fold(
            onSuccess = { flowers ->
                LoadResult.Page(
                    data = listOf(flowers),
                    prevKey = if (pageIndex == 0) null else pageIndex - 1,
                    nextKey = if (flowers.isEmpty()) null else pageIndex + 1
                )
            },
            onFailure = { error ->
                LoadResult.Error(error)
            }
        )


        TODO("Not yet implemented")
    }

}