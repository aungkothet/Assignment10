package io.github.aungkothet.padc.assignment10.data.models

import androidx.lifecycle.LiveData
import io.github.aungkothet.padc.assignment10.data.vos.*

interface MovieModel {

    fun getUpComingMovies(): LiveData<List<UpComingMoviesVo>>
    fun getPopularMovies(): LiveData<List<PopularMoviesVo>>
    fun getTopRatedMovies(): LiveData<List<TopRatedMoviesVo>>
    fun getSimilarMovies(movieId: Int): LiveData<List<SimilarMoviesVo>>
    fun getNowPlayingMovies(): LiveData<List<NowPlayingMovieVo>>

    fun getMovieById(id: Int): MovieVo
    fun searchMoviesByName(movieName: String): List<MovieVo>


}