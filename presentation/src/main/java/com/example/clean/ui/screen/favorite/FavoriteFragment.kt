package com.example.clean.ui.screen.favorite

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clean.R
import com.example.clean.databinding.FragmentFavoriteBinding
import com.example.clean.model.MovieItem
import com.example.clean.ui.base.BaseFragment
import com.example.clean.ui.screen.MainActivityViewModel
import com.example.clean.ui.screen.detail.DetailFragment
import com.example.clean.ui.screen.nowplaying.MovieAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    private val mainActivityViewModel: MainActivityViewModel by sharedViewModel()
    private val movieAdapter = MovieAdapter(::openDetail)

    companion object {
        const val TAG = "Favorite Fragment"
        fun newInstance() = FavoriteFragment()
    }

    override val viewModel: FavoriteViewModel by viewModel()

    override fun getLayoutResource() = R.layout.fragment_favorite

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        observeData()

        viewModel.getFavorites()
        mainActivityViewModel.titleActionBar.value = "Favorite Movies"
        mainActivityViewModel.isBackActionBar.value = false
    }

    private fun setupRecyclerView() {
        recycler_favorite.apply {
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
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            movieAdapter.submitList(it)
        })
    }

    private fun openDetail(movie: MovieItem) {
        replaceFragment(DetailFragment.newInstance(movie), DetailFragment.TAG, true)
    }
}