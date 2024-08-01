package com.pusu.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2

class PagingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val viewPager2 = ViewPager2(context).also {
        it.isUserInputEnabled = false
        it.overScrollMode = OVER_SCROLL_NEVER
    }

    init {
        addView(viewPager2, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
    }

    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        if (child != viewPager2 || childCount > 1) throw UnsupportedOperationException("PagingView add view is not supported")
    }

    override fun onViewRemoved(child: View) {
        super.onViewRemoved(child)
        throw UnsupportedOperationException("PagingView remove view is not supported")
    }

}