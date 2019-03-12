package com.example.clean.ui.screen.nowplaying

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clean.databinding.FragmentLoadmoreRefreshBinding
import com.example.clean.model.MovieItem
import com.example.clean.ui.base.BaseLoadMoreRefreshFragment
import kotlinx.android.synthetic.main.fragment_loadmore_refresh.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NowPlayingFragment :
    BaseLoadMoreRefreshFragment<FragmentLoadmoreRefreshBinding, NowPlayingViewModel, MovieItem>() {

    private val movieAdapter = MovieAdapter(::openDetail)

    companion object {
        const val TAG = "Now Playing Fragment"

        fun newInstance() = NowPlayingFragment()
    }

    override val viewModel: NowPlayingViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        observeData()

        viewModel.firstLoad()
    }

    private fun setupRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = movieAdapter
        }
    }

    private fun observeData() {
        viewModel.listItem.observe(viewLifecycleOwner, Observer {
            movieAdapter.submitList(it.toMutableList())
        })
    }

    private fun openDetail(movie: MovieItem) {

    }
}