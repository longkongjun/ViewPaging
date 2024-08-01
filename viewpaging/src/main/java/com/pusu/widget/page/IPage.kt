package com.pusu.widget.page

import androidx.recyclerview.widget.DiffUtil

interface IPage<T> {
    val pageIndex: Int
    val items: List<T>
}

class PageDiff<T> : DiffUtil.ItemCallback<IPage<T>>() {

    override fun areItemsTheSame(oldItem: IPage<T>, newItem: IPage<T>): Boolean {
        return oldItem.pageIndex == newItem.pageIndex
    }

    override fun areContentsTheSame(oldItem: IPage<T>, newItem: IPage<T>): Boolean {
        return false
    }

}