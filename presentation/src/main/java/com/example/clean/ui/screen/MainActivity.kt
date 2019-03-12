package com.example.clean.ui.screen

import android.os.Bundle
import com.example.clean.R
import com.example.clean.ui.base.BaseActivity
import com.example.clean.ui.screen.main.MainFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance()).commit()
        }
    }
}
