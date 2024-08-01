package com.pusu.widget.page

import android.view.View

interface IPageContainer<T : View> {

    fun root(): T
}