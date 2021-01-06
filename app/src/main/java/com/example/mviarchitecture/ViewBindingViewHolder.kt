package com.example.mviarchitecture

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 *
 * @author Sara Ebadi
 * @since 1/5/21
 */

abstract class viewBindingAdapter<Item: ViewBindingAdapterItem, VB: ViewBinding>
    (diffCallback: ViewBindingDiffCallback<Item>): ListAdapter<Item, ViewBindingViewHolder<Item,VB>>(diffCallback){

    override fun onBindViewHolder(holder: ViewBindingViewHolder<Item, VB>, position: Int) =
        holder.bind(item = getItem(position))

    override fun onBindViewHolder(
        holder: ViewBindingViewHolder<Item, VB>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        holder.bind(item = getItem(position), payloads = payloads)
    }
}
abstract class ViewBindingViewHolder<Item: ViewBindingAdapterItem, out VB: ViewBinding>(protected val binding: VB):
    RecyclerView.ViewHolder(binding.root){

    abstract fun bind(item: Item)

    open fun bind(item: Item, payloads: List<Any>){
        if(payloads.isEmpty())
            bind(item = item)
    }
}

abstract class ViewBindingDiffCallback<Item: ViewBindingAdapterItem>: DiffUtil.ItemCallback<Item>()