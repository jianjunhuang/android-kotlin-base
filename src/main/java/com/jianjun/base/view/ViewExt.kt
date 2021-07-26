package com.jianjun.base.view

import android.graphics.Paint
import android.util.TypedValue
import android.view.View
import com.jianjun.base.BaseApp

// ----------------------------- Measure -------------------------------------------
val Int.measureSize
    get() = View.MeasureSpec.getSize(this)
val Int.measureMode
    get() = View.MeasureSpec.getMode(this)

val Int.toAtMostSpec
    get() = View.MeasureSpec.makeMeasureSpec(this.measureSize, View.MeasureSpec.AT_MOST)
val Int.toExactlySpec
    get() = View.MeasureSpec.makeMeasureSpec(this.measureSize, View.MeasureSpec.EXACTLY)

val Float.dp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, BaseApp.getApp().resources.displayMetrics)

val Int.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        BaseApp.getApp().resources.displayMetrics
    )

val Paint.textHeight: Float
    get() {
        val fontMetrics = this.fontMetrics
        return fontMetrics.bottom - fontMetrics.top + fontMetrics.leading
    }

