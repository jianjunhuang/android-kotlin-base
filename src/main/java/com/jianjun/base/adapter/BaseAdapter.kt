package com.jianjun.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<D : Any, V : BaseViewHolder<D>> : RecyclerView.Adapter<V>() {

    protected abstract fun onDiffCallback(): DiffUtil.ItemCallback<D>

    private val diffUtil = AsyncListDiffer<D>(this, onDiffCallback())

    protected var clickListener: OnItemClickListener<D>? = null
    protected var longClickListener: OnItemLongClickListener<D>? = null

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

    fun setOnItemClickListener(clickListener: OnItemClickListener<D>) {
        this.clickListener = clickListener
    }

    fun setOnItemLongClickListener(clickListener: OnItemLongClickListener<D>) {
        this.longClickListener = clickListener
    }

    interface OnItemClickListener<D : Any> {
        fun onItemClicked(position: Int, data: D, adapter: BaseAdapter<D, *>)
    }

    interface OnItemLongClickListener<D : Any> {
        fun onItemLongClicked(position: Int, data: D, adapter: BaseAdapter<D, *>)
    }

    fun BaseViewHolder<D>.bindClick() {
        this.itemView.setOnClickListener {
            clickListener?.onItemClicked(
                this.adapterPosition,
                diffUtil.currentList[adapterPosition],
                this@BaseAdapter
            )
        }
    }

    fun BaseViewHolder<D>.bindLongClick() {
        this.itemView.setOnLongClickListener {
            longClickListener?.onItemLongClicked(
                this.adapterPosition,
                diffUtil.currentList[adapterPosition],
                this@BaseAdapter
            )
            return@setOnLongClickListener true
        }
    }
}