package com.example.clean.ui.screen

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.clean.R
import com.example.clean.ui.base.BaseActivity
import com.example.clean.ui.screen.main.MainFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceMainFragment()
        }

        observeData()
    }

    private fun replaceMainFragment() {
        var fragment = supportFragmentManager.findFragmentByTag(MainFragment.TAG)
        if (fragment == null) {
            fragment = MainFragment.newInstance()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, MainFragment.TAG)
            .addToBackStack(MainFragment.TAG)
            .commit()
    }

    private fun observeData() {
        viewModel.isBackActionBar.observe(this, Observer {
            if (it == true) {
                showBackActionBar()
            } else {
                hideBackActionBar()
            }
        })
        viewModel.titleActionBar.observe(this, Observer {
            titleActionBar(it)
        })
    }
}
