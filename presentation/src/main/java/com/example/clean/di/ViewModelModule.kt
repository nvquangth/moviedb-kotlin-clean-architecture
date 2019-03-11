package com.example.clean.di

import com.example.clean.ui.screen.MainActivityViewModel
import com.example.clean.ui.screen.detail.DetailViewModel
import com.example.clean.ui.screen.favorite.FavoriteViewModel
import com.example.clean.ui.screen.main.MainViewModel
import com.example.clean.ui.screen.nowplaying.NowPlayingViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<MainActivityViewModel>()
    viewModel<DetailViewModel>()
    viewModel<FavoriteViewModel>()
    viewModel<MainViewModel>()
    viewModel<NowPlayingViewModel>()
}