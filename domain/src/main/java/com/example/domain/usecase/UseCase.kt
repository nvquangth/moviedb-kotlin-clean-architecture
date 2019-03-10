package com.example.domain.usecase

/**
 *   Created by quangnv on 10/03/2019
 */

abstract class UseCase<in Params, out T> where T: Any{

    abstract fun createObservable(params: Params? = null): T

    abstract fun onCleared()
}