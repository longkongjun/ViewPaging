package com.pusu.widget.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pusu.widget.page.IPage
import com.pusu.widget.page.PageDiff

class PageListAdapter<T> : ListAdapter<IPage<T>, ListViewHolder<T>>(PageDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder<T> {

        return ListViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder<T>, position: Int) {
        holder.layoutPage(getItem(position).items)
    }

}

class ListViewHolder<T>(parent: ViewGroup) : RecyclerView.ViewHolder(container), IPagingAdapter<RecyclerView, T> {

    private val container = RecyclerView(parent.context).also {
        it.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        it.itemAnimator = null
    }

    override fun pageView(context: Context) = container

    override fun layoutPage(pageItems: List<T>) {
        TODO("Not yet implemented")
    }

}