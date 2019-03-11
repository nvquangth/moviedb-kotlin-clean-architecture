package com.example.clean.ui.base

import androidx.databinding.ViewDataBinding
import com.example.clean.R

abstract class BaseLoadMoreRefreshFragment<VB : ViewDataBinding, VM : BaseLoadMoreRefreshViewModel<Item>, Item> :
    BaseFragment<VB, VM>() {


    override fun getLayoutResource() = R.layout.fragment_loadmore_refresh

    override fun handleShowLoading(isLoading: Boolean) {
        // use progress bar
    }
}