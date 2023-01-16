package com.chow.autospangridlayoutinrecyclerview.scrollstate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chow.autospangridlayoutinrecyclerview.databinding.ItemBigTvBinding

class BigTextAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<BigTextAdapter.BigBTextViewHolder>() {

    class BigBTextViewHolder(val binding: ItemBigTvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BigBTextViewHolder(
        ItemBigTvBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: BigBTextViewHolder, position: Int) {
        holder.binding.tvContent.text = data[position]
    }

    override fun getItemCount() = data.size
}