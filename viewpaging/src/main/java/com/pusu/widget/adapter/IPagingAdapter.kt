package com.pusu.widget.adapter

import android.content.Context
import android.view.View

sealed interface IPagingAdapter<T, S> where T : View {

    fun pageView(context: Context): T

    fun layoutPage(pageItems: List<S>)
}

interface IPagingContainer<T : View>{
    fun pageView(context: Context): T
}

