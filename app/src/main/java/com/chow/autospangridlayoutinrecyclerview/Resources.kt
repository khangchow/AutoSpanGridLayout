package com.chow.autospangridlayoutinrecyclerview

import android.annotation.SuppressLint
import android.content.Context

class Resources {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun init(context: Context) {
            this.context = context
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun getDrawable(id: Int) = context.getDrawable(id)

    }
}