package com.pusu.viewpaging.page

interface PageModel<T> {

    /**
     * 加载指定页面的数据
     * @param page 页面索引
     */
    fun loadPage(page: Int): Result<T>

}