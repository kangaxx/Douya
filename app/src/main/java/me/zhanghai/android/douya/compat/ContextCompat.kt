/*
 * Copyright (c) 2020 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.douya.compat

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import androidx.annotation.StyleableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.TintTypedArray

fun Context.getDrawableCompat(@DrawableRes id: Int): Drawable =
    AppCompatResources.getDrawable(this, id)!!

fun Context.obtainStyledAttributesCompat(
    set: AttributeSet? = null,
    @StyleableRes attrs: IntArray,
    @StyleRes defStyleRes: Int = 0,
    @AttrRes defStyleAttr: Int = 0
): TintTypedArray =
    TintTypedArray.obtainStyledAttributes(this, set, attrs, defStyleAttr, defStyleRes)

inline fun <R> TintTypedArray.use(block: (TintTypedArray) -> R): R =
    AutoCloseable { recycle() }.use { block(this) }
