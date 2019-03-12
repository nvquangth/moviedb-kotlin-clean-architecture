package com.example.clean.ui.screen.main

import android.os.Bundle
import com.example.clean.R
import com.example.clean.databinding.FragmentMainBinding
import com.example.clean.ui.base.BaseFragment
import com.example.clean.ui.screen.nowplaying.NowPlayingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    companion object {
        const val TAG = "Main Fragment"
        fun newInstance() = MainFragment()
    }

    override val viewModel by viewModel<MainViewModel>()

    override fun getLayoutResource() = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        replaceChildFragment(
            this,
            R.id.container,
            NowPlayingFragment.newInstance(),
            NowPlayingFragment.TAG,
            false
        )
    }
}