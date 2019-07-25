package com.example.clean.ui.screen.nowplaying

import com.example.clean.model.MovieItem
import com.example.clean.model.MovieItemMapper
import com.example.clean.ui.base.BaseLoadMoreRefreshViewModel
import com.example.domain.usecase.movie.GetListMoviesUseCase
import com.sample.clean.rx.SchedulerProvider

class NowPlayingViewModel(
    private val scheduler: SchedulerProvider,
    private val getListMoviesUseCase: GetListMoviesUseCase,
    private val mapper: MovieItemMapper
) : BaseLoadMoreRefreshViewModel<MovieItem>() {

    override fun loadData(page: Int) {
        addDisposable(getListMoviesUseCase.createObservable(GetListMoviesUseCase.Params(true, page))
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .map { data ->
                data.map {
                    mapper.mapToPresentation(it)
                }
            }
            .subscribe({
                onLoadSuccess(page, it)
            }, {
                onLoadFail(it)
            })
        )
    }
}