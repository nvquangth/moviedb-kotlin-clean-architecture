package com.example.clean.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.clean.BR
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<T, VB : ViewDataBinding>(
    callBack: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<VB>>(
    AsyncDifferConfig.Builder<T>(callBack)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<VB> {
        return BaseViewHolder(DataBindingUtil.inflate<VB>(
            LayoutInflater.from(parent.context),
            getLayoutResource(viewType),
            parent, false
        ).apply {
            bindFirstTime(this)
        })
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        try {
            val item: T = getItem(position)
            holder.binding.setVariable(BR.item, item)
            bindView(holder.binding, item, position)
        } catch (e: IndexOutOfBoundsException) {
            bind(holder.binding, position)
        }
        holder.binding.executePendingBindings()
    }

    override fun submitList(list: MutableList<T>?) {
        val newList = ArrayList<T>()
        if (list != null) {
            newList.addAll(list)
        }
        super.submitList(newList)
    }

    protected open fun bindFirstTime(binding: VB) {
    }

    protected open fun bindView(binding: VB, item: T, position: Int) {
    }

    protected open fun bind(binding: VB, position: Int) {
    }

    @LayoutRes
    abstract fun getLayoutResource(viewType: Int): Int
}