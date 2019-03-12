package com.example.clean.ui.screen.main

import android.os.Bundle
import com.example.clean.R
import com.example.clean.databinding.FragmentMainBinding
import com.example.clean.ui.base.BaseFragment
import com.example.clean.ui.screen.favorite.FavoriteFragment
import com.example.clean.ui.screen.nowplaying.NowPlayingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_main.*
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
        if (savedInstanceState == null) {
            replaceNowPlayingFragment()
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceNowPlayingFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favorite -> {
                    replaceFavoriteFragment()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun replaceNowPlayingFragment() {
        var fragment = findChildFragment(this, NowPlayingFragment.TAG)
        if (fragment == null) {
            fragment = NowPlayingFragment.newInstance()
        }
        replaceChildFragment(
            this,
            R.id.container,
            fragment,
            NowPlayingFragment.TAG,
            true
        )
    }

    private fun replaceFavoriteFragment() {
        var fragment = findChildFragment(this, FavoriteFragment.TAG)
        if (fragment == null) {
            fragment = FavoriteFragment.newInstance()
        }
        replaceChildFragment(
            this,
            R.id.container,
            fragment,
            FavoriteFragment.TAG,
            true
        )
    }
}