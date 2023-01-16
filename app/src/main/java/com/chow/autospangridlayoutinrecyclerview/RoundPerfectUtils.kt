package com.chow.autospangridlayoutinrecyclerview

import android.content.res.Resources

object RoundPerfectUtils {
    fun max(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }
}