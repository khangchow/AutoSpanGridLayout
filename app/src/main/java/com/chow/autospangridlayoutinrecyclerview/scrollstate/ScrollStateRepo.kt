package com.chow.autospangridlayoutinrecyclerview.scrollstate

import com.chow.autospangridlayoutinrecyclerview.ListHelper

class ScrollStateRepo {
    fun getData() = listOf(
        TitleListModel("List A", ListHelper.createListNumber(20)),
        TitleListModel("List B", ListHelper.createListNumber(20)),
        TitleListModel("List C", ListHelper.createListNumber(20)),
        TitleListModel("List D", ListHelper.createListNumber(20)),
        TitleListModel("List E", ListHelper.createListNumber(20)),
        TitleListModel("List F", ListHelper.createListNumber(20)),
        TitleListModel("List G", ListHelper.createListNumber(20)),
        TitleListModel("List H", ListHelper.createListNumber(20)),
        TitleListModel("List I", ListHelper.createListNumber(20)),
    )
}