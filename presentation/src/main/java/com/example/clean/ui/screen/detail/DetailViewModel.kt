package com.example.clean.ui.screen.detail

import androidx.lifecycle.MutableLiveData
import androidx.room.EmptyResultSetException
import com.example.clean.model.MovieItem
import com.example.clean.model.MovieItemMapper
import com.example.clean.ui.base.BaseViewModel
import com.example.domain.repository.MovieRepository
import com.sample.clean.rx.SchedulerProvider

class DetailViewModel(
    private val repository: MovieRepository,
    private val scheduler: SchedulerProvider,
    private val mapper: MovieItemMapper
) : BaseViewModel() {
    val movie: MutableLiveData<MovieItem> = MutableLiveData()
    val isFavorite: MutableLiveData<Boolean> = MutableLiveData()

    fun checkFavorite() {
        movie.value?.let {
            addDisposable(
                repository.getMovie(it.id, false)
                    .subscribeOn(scheduler.io())
                    .observeOn(scheduler.ui())
                    .subscribe({
                        isFavorite.value = true
                    }, { throwable ->
                        if (throwable is EmptyResultSetException) {
                            isFavorite.value = false
                        }
                    })
            )
        }
    }

    fun addOrRemoveFavorite() {
        if (isFavorite.value == true) {
            movie.value?.let {
                deleteMovie(it)
            }
        } else {
            movie.value?.let {
                addMovie(it)
            }
        }
    }

    private fun deleteMovie(movie: MovieItem) {
        addDisposable(repository.deleteMovie(mapper.mapToDomain(movie))
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe {
                isFavorite.value = false
            })
    }

    private fun addMovie(movie: MovieItem) {
        addDisposable(repository.insertMovie(mapper.mapToDomain(movie))
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe {
                isFavorite.value = true
            })
    }
}