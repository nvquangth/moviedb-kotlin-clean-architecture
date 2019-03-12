package com.example.clean.ui.screen.favorite

import androidx.lifecycle.MutableLiveData
import com.example.clean.model.MovieItem
import com.example.clean.model.MovieItemMapper
import com.example.clean.ui.base.BaseViewModel
import com.example.domain.repository.MovieRepository
import com.sample.clean.rx.SchedulerProvider

class FavoriteViewModel(
    private val repository: MovieRepository,
    private val scheduler: SchedulerProvider,
    private val mapper: MovieItemMapper
) : BaseViewModel() {

    var movies: MutableLiveData<MutableList<MovieItem>> = MutableLiveData()

    fun getFavorites() {
        addDisposable(repository.getMovies(false, null)
            .map {data ->
                data.map { mapper.mapToPresentation(it) }
            }
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe({
                movies.value = it.toMutableList()
            }, {
                onLoadFail(it)
            }))
    }
}
