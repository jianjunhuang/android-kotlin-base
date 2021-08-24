package com.jianjun.base.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<D : Any, V : BaseViewHolder<*>> : RecyclerView.Adapter<V>() {

    protected abstract fun onDiffCallback(): DiffUtil.ItemCallback<D>

    private val diffUtil = AsyncListDiffer<D>(this, onDiffCallback())

    protected var clickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: V, position: Int) {
        onBindViewHolder(holder, position, getData(position))
    }

    protected abstract fun onBindViewHolder(holder: V, position: Int, data: D)

    fun getData(position: Int): D {
        return diffUtil.currentList[position]
    }

    override fun getItemCount(): Int {
        return diffUtil.currentList.size
    }

    fun update(dataList: List<D>) {
        diffUtil.submitList(dataList)
    }

    fun update(dataList: List<D>, callback: Runnable) {
        diffUtil.submitList(dataList, callback)
    }

    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        this.clickListener = clickListener
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int)
    }
}