package com.chow.autospangridlayoutinrecyclerview.flexbox

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chow.autospangridlayoutinrecyclerview.ListHelper.getMaxWidth
import com.chow.autospangridlayoutinrecyclerview.ListHelper.getMinWidth
import com.chow.autospangridlayoutinrecyclerview.RoundUtils.roundMaxPerfect
import com.chow.autospangridlayoutinrecyclerview.RoundUtils.roundMinPerfect

class FlexBoxViewModel : ViewModel() {
    private val _list = MutableLiveData<List<TextWidthModel>>()
    val list = _list
    private val _tempList = MutableLiveData<MutableList<TextWidthModel>>()
    val tempList = _tempList

    fun getData() {
        _tempList.postValue(Repo().getData().toMutableList())
    }

    fun updateListItem(pos: Int, width: Int) {
        _tempList.value?.apply {
            get(pos).let {
                removeAt(pos)
                add(pos, it.apply {
                    this.width = width
                })
            }
            if (pos == size - 1) _list.postValue(this)
        }
    }

    fun calculateSpanCount() = (getMaxWidthItem() / getMinWidthItem()).let {
        if (it.toFloat() != getMaxWidthItem().toFloat() / getMinWidthItem()) it + 1
        else it
    }

    fun getMinWidthItem() = (_list.value as List<TextWidthModel>).getMinWidth().roundMinPerfect()
    private fun getMaxWidthItem() = (_list.value as List<TextWidthModel>).getMaxWidth().roundMaxPerfect()
}