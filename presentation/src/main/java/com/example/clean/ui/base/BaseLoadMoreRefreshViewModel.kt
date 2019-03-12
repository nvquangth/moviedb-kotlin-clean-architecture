package com.example.clean.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.clean.Constants
import com.example.clean.ui.widgets.EndlessRecyclerOnScrollListener
import com.example.domain.Constants.DEFAULT_ITEM_PER_PAGE

abstract class BaseLoadMoreRefreshViewModel<Item> : BaseViewModel() {

    val isRefreshing = MutableLiveData<Boolean>(false)
    val isLoadMore = MutableLiveData<Boolean>(false)
    val currentPage = MutableLiveData(0)
    val isLastPage = MutableLiveData<Boolean>(false)
    val listItem = MutableLiveData<ArrayList<Item>>()
    val onScrollListener = object : EndlessRecyclerOnScrollListener(getLoadMoreThreshold()) {
        override fun onLoadMore() {
            if (isLoading.value == true
                || isRefreshing.value == true
                || isLoadMore.value == true
                || isLastPage.value == true
            ) return
            isLoadMore.value = true
            loadMore()
        }
    }
    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        if (isLoading.value == true || isRefreshing.value == true) return@OnRefreshListener
        isRefreshing.value = true
        refreshData()
    }

    fun refreshData() {
        loadData(1)
    }

    fun isFirst() = currentPage.value == 0 && (listItem.value == null || listItem.value?.size == 0)

    // Default u must call this fun on first time
    fun firstLoad() {
        if (isFirst()) {
            isLoading.value = true
            loadData(1)
        }
    }

    fun getLoadMoreThreshold() = Constants.DEFAULT_NUM_VISIBLE_THRESHOLD

    fun getNumberItemPerPage() = DEFAULT_ITEM_PER_PAGE

    fun loadMore() {
        loadData(currentPage.value?.plus(1) ?: 1)
    }

    fun resetLoadMore() {
        onScrollListener.resetOnLoadMore()
        isLastPage.value = false
    }

    fun onLoadSuccess(page: Int, items: List<Item>?) {
        currentPage.value = page
        if (currentPage.value == 1) listItem.value?.clear()
        if (isRefreshing.value == true) resetLoadMore()

        val newList = listItem.value ?: ArrayList()
        newList.addAll(items ?: listOf())
        listItem.value = newList

        isLastPage.value = items?.size ?: 0 < getNumberItemPerPage()
        isLoading.value = false
        isRefreshing.value = false
        isLoadMore.value = false
    }

    override fun onLoadFail(throwable: Throwable) {
        super.onLoadFail(throwable)
        isRefreshing.value = false
        isLoadMore.value = false
    }

    abstract fun loadData(page: Int)
}