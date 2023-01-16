package com.chow.autospangridlayoutinrecyclerview.scrollstate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chow.autospangridlayoutinrecyclerview.databinding.ItemTvBinding

class ItemRowRecViewAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<ItemRowRecViewAdapter.TextViewHolder>() {

    class TextViewHolder(val binding: ItemTvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TextViewHolder(
        ItemTvBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.binding.tvContent.text = data[position]
    }

    override fun getItemCount() = data.size
}