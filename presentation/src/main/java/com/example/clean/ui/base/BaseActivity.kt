package com.example.clean.ui.base

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun showBackActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideBackActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun titleActionBar(title: String) {
        supportActionBar?.title = title
    }
}