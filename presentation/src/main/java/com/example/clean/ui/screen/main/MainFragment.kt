package com.example.clean.ui.screen.main

import com.example.clean.R
import com.example.clean.databinding.FragmentMainBinding
import com.example.clean.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    companion object {
        const val TAG = "Main Fragment"
        fun newInstance() = MainFragment()
    }

    override val viewModel by viewModel<MainViewModel>()

    override fun getLayoutResource() = R.layout.fragment_main
}