package com.jianjun.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.FrameMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class CustomViewGroup : ViewGroup {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }


    protected inline fun <T : View> T.added(block: T.() -> Unit): T {
        block()
        addView(this)
        return this
    }

    protected inline fun <T : View> T.added(block: T.() -> Unit, params: LayoutParams): T {
        block()
        addView(this)
        return this
    }

}