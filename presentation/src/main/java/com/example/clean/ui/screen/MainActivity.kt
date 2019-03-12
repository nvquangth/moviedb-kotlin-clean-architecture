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
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance()).commit()
        }

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
