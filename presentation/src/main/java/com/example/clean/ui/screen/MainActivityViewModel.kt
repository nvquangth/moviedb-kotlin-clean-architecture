package com.example.clean.ui.screen

import androidx.lifecycle.MutableLiveData
import com.example.clean.ui.base.BaseViewModel

class MainActivityViewModel: BaseViewModel() {
    val isBackActionBar: MutableLiveData<Boolean> = MutableLiveData(false)
    val titleActionBar: MutableLiveData<String> = MutableLiveData()
}