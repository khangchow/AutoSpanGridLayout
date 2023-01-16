package com.chow.autospangridlayoutinrecyclerview

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Resources.init(this)
    }

}