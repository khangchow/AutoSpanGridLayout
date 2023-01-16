package com.chow.autospangridlayoutinrecyclerview.scrollstate

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.reflect.KFunction0

class ScrollStateViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        const val LIST_DATA = "LIST_DATA"
    }

    private val _list = state.getLiveData<List<TitleListModel>>(LIST_DATA)
    val list = _list
    private val repo = ScrollStateRepo()
    private var isScreenRotated = false

    fun showData() {
        if (!isScreenRotated) refreshData()
        else isScreenRotated = false
    }

    fun updateListOnDestroy(scrollStates: HashMap<Int, Parcelable>) {
        val list = mutableListOf<TitleListModel>()
        (_list.value as List<TitleListModel>).mapIndexed { index, it ->
            list.add(it.copy(scrollState = scrollStates[index]))
        }
        _list.postValue(list)
        isScreenRotated = true
    }

    fun refreshData() {
        _list.postValue(repo.getData())
    }

    fun saveListState(scrollStates: HashMap<Int, Parcelable>) {
        updateListOnDestroy(scrollStates)
        state[LIST_DATA] = _list.value
    }
}