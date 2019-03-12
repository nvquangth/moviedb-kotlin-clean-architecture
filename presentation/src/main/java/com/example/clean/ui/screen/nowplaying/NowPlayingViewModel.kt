package com.example.clean.ui.screen.nowplaying

import com.example.clean.model.MovieItem
import com.example.clean.model.MovieItemMapper
import com.example.clean.ui.base.BaseLoadMoreRefreshViewModel
import com.example.domain.repository.MovieRepository
import com.sample.clean.rx.SchedulerProvider

class NowPlayingViewModel(
    private val repository: MovieRepository,
    private val scheduler: SchedulerProvider,
    private val mapper: MovieItemMapper
) : BaseLoadMoreRefreshViewModel<MovieItem>() {

    override fun loadData(page: Int) {
        addDisposable(repository.getMovies(true, page)
            .map { data ->
                data.map {
                    mapper.mapToPresentation(it)
                }
            }
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe({
                onLoadSuccess(page, it)
            }, {
                onLoadFail(it)
            })
        )
    }
}