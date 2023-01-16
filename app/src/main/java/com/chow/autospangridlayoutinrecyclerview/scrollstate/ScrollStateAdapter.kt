package com.chow.autospangridlayoutinrecyclerview.scrollstate

import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chow.autospangridlayoutinrecyclerview.databinding.ItemRowBinding

class ScrollStateAdapter(private var data: List<TitleListModel> = emptyList()) : RecyclerView.Adapter<ScrollStateAdapter.RowRecViewHolder>() {
    class RowRecViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)
    private var scrollStates = hashMapOf<Int, Parcelable>()
    private var isScrollStateReset = hashMapOf<Int, Boolean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RowRecViewHolder(
        ItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: RowRecViewHolder, position: Int) {
        val item = data[holder.absoluteAdapterPosition]
        holder.binding.run {
            rvRow.apply {
                adapter = BigTextAdapter(item.list)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                if (isScrollStateReset[holder.absoluteAdapterPosition] == null) {
                    (holder.binding.rvRow.layoutManager as LinearLayoutManager).onRestoreInstanceState(
                        item.scrollState
                    )
                    isScrollStateReset[holder.absoluteAdapterPosition] = true
                    item.scrollState?.let {
                        scrollStates[holder.absoluteAdapterPosition] = it
                    }
                } else {
                    (holder.binding.rvRow.layoutManager as LinearLayoutManager).onRestoreInstanceState(
                        scrollStates[holder.absoluteAdapterPosition]
                    )
                }
                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)
                        when (newState) {
                            RecyclerView.SCROLL_STATE_IDLE -> {
                                ((holder.binding.rvRow.layoutManager as LinearLayoutManager).onSaveInstanceState() as Parcelable).let {
                                    scrollStates[holder.absoluteAdapterPosition] = it
                                }
                            }
                        }
                    }
                })
            }
            tvTitle.text = data[position].title
        }
    }

    fun updateList(data: List<TitleListModel>) {
        this.data = data
        scrollStates.clear()
        isScrollStateReset.clear()
        notifyDataSetChanged()
    }

    fun getScrollStates() = scrollStates

    override fun getItemCount() = data.size
}