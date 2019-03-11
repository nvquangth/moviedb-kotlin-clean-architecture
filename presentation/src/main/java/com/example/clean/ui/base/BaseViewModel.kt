package com.example.clean.ui.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clean.data.remote.BaseException
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val errorMessage = MutableLiveData<String>()
    val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun onActivityDestroyed() {
        compositeDisposable.clear()
    }

    open fun onLoadFail(throwable: Throwable) {
        try {
            when (throwable) {
                is BaseException -> {
                    when (throwable.cause) {
                        is UnknownHostException -> {
                            errorMessage.value = "No Internet Exception"
                        }
                        is SocketTimeoutException -> {
                            errorMessage.value = "Connect timeout, please retry"
                        }
                        else -> {
                            errorMessage.value = throwable.message
                        }
                    }
                }
                else -> {
                    errorMessage.value = throwable.message
                }
            }
        } catch (e: Exception) {
            errorMessage.value = throwable.message
        }
        isLoading.value = false
    }

    open fun showError(e: Throwable) {
        errorMessage.value = e.message
    }
}