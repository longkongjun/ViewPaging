package com.pusu.viewpaging.page

import android.util.Size

/**
 * 页面测量
 */
fun interface PageMeasurer : (Int) -> Size {

    /**
     * 测量指定页面的尺寸
     * @param index 页面索引
     * @return 页面尺寸
     */
    override fun invoke(index: Int): Size

}