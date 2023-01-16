package com.chow.autospangridlayoutinrecyclerview.scrollstate

import android.os.Parcelable

data class TitleListModel(
    var title: String,
    val list: List<String>,
    var scrollState: Parcelable? = null
)