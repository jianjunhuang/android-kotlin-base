package com.jianjun.base.ext

import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils

val Int.isDark
    get() = ColorUtils.calculateLuminance(this) > 0.5

/**
 * return color string, format is '#xxxxxx'
 */
val Int.toHexColor
    get() = String.format("#%06X", 0xFFFFFF and this)

val Int.toHexColorAlpha
    get() = String.format("#%08X", 0xFFFFFFFF and this.toLong())
