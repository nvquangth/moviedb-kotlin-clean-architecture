package com.example.clean.ui.screen.nowplaying

import androidx.recyclerview.widget.DiffUtil
import com.example.clean.R
import com.example.clean.databinding.ItemMovieBinding
import com.example.clean.model.MovieItem
import com.example.clean.ui.base.BaseRecyclerAdapter

class MovieAdapter(private val listener: (MovieItem) -> Unit) :
    BaseRecyclerAdapter<MovieItem, ItemMovieBinding>(object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun getLayoutResource(viewType: Int) = R.layout.item_movie

    override fun bindFirstTime(binding: ItemMovieBinding) {
        super.bindFirstTime(binding)
        binding.root.setOnClickListener {
            binding.item?.let {
                listener.invoke(it)
            }
        }
    }
}