package com.example.clean.ui.nowplaying

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.clean.base.BaseTest
import com.example.clean.model.MovieItemMapper
import com.example.clean.ui.screen.nowplaying.NowPlayingViewModel
import com.example.clean.util.rx.AppSchedulerProvider
import com.example.domain.model.Movie
import com.example.domain.usecase.movie.GetListMoviesUseCase
import io.reactivex.Single
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy

class NowPlayingViewModelTest: BaseTest() {

    private lateinit var viewModel: NowPlayingViewModel

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Spy
    private lateinit var scheduler: AppSchedulerProvider

    @Mock
    private lateinit var getListMoviesUseCase: GetListMoviesUseCase

    @Mock
    private lateinit var movieItemMapper: MovieItemMapper

    override fun setup() {
        super.setup()
        viewModel = NowPlayingViewModel(
            scheduler = scheduler,
            getListMoviesUseCase = getListMoviesUseCase,
            mapper = movieItemMapper
        )
    }

    @Test
    fun isLoading_Test_ReturnTrue() {
        // define
        val single = Single.just(listOf<Movie>())
        Mockito.`when`(getListMoviesUseCase.createObservable(ArgumentMatchers.any(GetListMoviesUseCase.Params::class.java))).thenAnswer {
            single
        }

        val observer = Mockito.mock(Observer::class.java) as Observer<Boolean>
        viewModel.isLoading.observeForever(observer)

        // invoke
        viewModel.loadData(ArgumentMatchers.anyInt())

        // testing
        Assert.assertEquals(false, viewModel.isLoading.value)
    }
}