package com.jianjun.base.ext

import android.content.res.Resources
import android.graphics.Paint
import android.util.TypedValue
import android.view.View

// ----------------------------- Measure -------------------------------------------
val Int.measureSize
    get() = View.MeasureSpec.getSize(this)
val Int.measureMode
    get() = View.MeasureSpec.getMode(this)

val Int.toAtMostSpec
    get() = View.MeasureSpec.makeMeasureSpec(this.measureSize, View.MeasureSpec.AT_MOST)
val Int.toExactlySpec
    get() = View.MeasureSpec.makeMeasureSpec(this.measureSize, View.MeasureSpec.EXACTLY)

fun View.measureMatchParent(widthSpec: Int, heightSpec: Int) {
    this.measure(
        widthSpec.measureSize.toExactlySpec,
        heightSpec.measureSize.toExactlySpec
    )
}

fun View.measureWrapContent(widthSpec: Int, heightSpec: Int) {
    this.measure(
        widthSpec.measureSize.toAtMostSpec,
        heightSpec.measureSize.toAtMostSpec
    )
}

fun View.measureExactly(widthSize: Int, heightSize: Int) {
    this.measure(
        widthSize.toExactlySpec,
        heightSize.toExactlySpec
    )
}

// ---------------------------- Convert ---------------------------------------------
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )


// ---------------------------- Get Size ---------------------------------------------
val Paint.textHeight: Float
    get() {
        val fontMetrics = this.fontMetrics
        return fontMetrics.bottom - fontMetrics.top + fontMetrics.leading
    }

