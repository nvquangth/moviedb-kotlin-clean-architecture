package com.example.clean.di

import com.example.clean.util.rx.AppSchedulerProvider
import com.sample.clean.rx.SchedulerProvider
import org.koin.dsl.module.module
import org.koin.experimental.builder.singleBy

val rxModule = module {
    singleBy<SchedulerProvider, AppSchedulerProvider>()
}