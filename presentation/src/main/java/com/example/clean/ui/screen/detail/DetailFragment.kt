package com.example.clean.ui.screen.detail

import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.clean.R
import com.example.clean.databinding.FragmentDetailBinding
import com.example.clean.model.MovieItem
import com.example.clean.ui.base.BaseFragment
import com.example.clean.ui.screen.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    private val mainActivityViewModel: MainActivityViewModel by sharedViewModel()

    companion object {
        const val TAG = "DetailFragment"
        private const val ARGUMENT_MOVIE = "ARGUMENT_MOVIE"
        fun newInstance(movie: MovieItem) = DetailFragment().apply {
            arguments = bundleOf(
                ARGUMENT_MOVIE to movie
            )
        }
    }

    override val viewModel: DetailViewModel by viewModel()

    override fun getLayoutResource() = R.layout.fragment_detail

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movie: MovieItem? = arguments?.getParcelable(ARGUMENT_MOVIE)
        viewModel.movie.value = movie ?: return
        viewModel.checkFavorite()
        mainActivityViewModel.isBackActionBar.value = true
        mainActivityViewModel.titleActionBar.value = movie.title
    }
}