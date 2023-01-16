package com.chow.autospangridlayoutinrecyclerview.flexbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chow.autospangridlayoutinrecyclerview.databinding.ItemTvBinding


class ItemAdapter(
    private var data: List<TextWidthModel>,
) : RecyclerView.Adapter<ItemAdapter.TextViewHolder>() {

    class TextViewHolder(val binding: ItemTvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TextViewHolder(
        ItemTvBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.binding.tvContent.apply {
            text = data[position].content
        }
    }

    fun updateList(data: List<TextWidthModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size
}