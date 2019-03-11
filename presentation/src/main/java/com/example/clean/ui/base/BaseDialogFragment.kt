package com.example.clean.ui.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment<T : ViewDataBinding> : DialogFragment() {

    lateinit var binding: T

    @LayoutRes
    abstract fun getLayoutResource(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.apply {
            isCancelable = false
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }
}