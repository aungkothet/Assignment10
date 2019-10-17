package io.github.aungkothet.padc.assignment10.network.dataAgents

import androidx.lifecycle.LiveData
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.network.responses.TrailerVideoResponse


interface MovieDataAgent {
    fun getNowPlayingMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getPopularMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTopRatedMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getSimilarMovies(
        movieId: Int,
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getUpComingMovies(
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun searchMovies(
        query: String,
        page: Int,
        onSuccess: (List<MovieVo>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun getTrailerVideos(
        movieId: Int,
        onSuccess: (TrailerVideoResponse) -> Unit,
        onFailure: (String) -> Unit
    )




}