package com.tick.taku.example.paging3.ui.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tick.taku.example.paging3.databinding.ViewCatBinding
import com.tick.taku.example.paging3.entity.Cat

class CatPagingAdapter: PagingDataAdapter<Cat, CatPagingAdapter.ViewHolder>(diffCallBack) {

    inner class ViewHolder(val binding: ViewCatBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ViewCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cat = getItem(position)
    }

}

private val diffCallBack = object: DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean = oldItem == newItem
}