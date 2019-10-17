package io.github.aungkothet.padc.assignment10.mvp.views

import io.github.aungkothet.padc.assignment10.data.vos.MovieVo

interface MainView:BaseView {

    //homeFragment
    fun showMainMovieList(movieList: List<List<MovieVo>>)

    //searchFragment
    fun showResultMovieList(movieList: List<MovieVo>)

    fun navigateToMovieDetail(movieId: Int)
    fun showErrorMessage(message: String)



}