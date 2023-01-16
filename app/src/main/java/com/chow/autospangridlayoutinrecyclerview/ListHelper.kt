package com.chow.autospangridlayoutinrecyclerview

import com.chow.autospangridlayoutinrecyclerview.flexbox.TextWidthModel

object ListHelper {
    fun createListNumber(num: Int) = (1..num).map { it.toString() }

    fun List<TextWidthModel>.getMaxWidth() = maxByOrNull { it.width }?.width ?: 0

    fun List<TextWidthModel>.getMinWidth() = minByOrNull { it.width }?.width ?: 0
}