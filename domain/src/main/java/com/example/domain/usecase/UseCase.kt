package com.example.domain.usecase

/**
 *   Created by quangnv on 10/03/2019
 */

abstract class UseCase<in Params, out T> where T: Any{

    abstract fun createFlow(params: Params? = null): T
}