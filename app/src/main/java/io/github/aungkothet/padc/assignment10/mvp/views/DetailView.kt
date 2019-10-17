package io.github.aungkothet.padc.assignment10.mvp.views

import io.github.aungkothet.padc.assignment10.data.vos.MovieVo

interface DetailView : BaseView {

    fun bindMovieData(movieVo: MovieVo)
    fun showSimilarMovies(movieList: List<MovieVo>)
    fun navigateToMovieDetail(movieId: Int)
    fun showErrorMessage(message: String)
    fun bindVideoData(videoId:String?)
    fun showTrailerVideoDialog()
}