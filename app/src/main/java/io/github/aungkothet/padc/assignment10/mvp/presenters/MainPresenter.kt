package io.github.aungkothet.padc.assignment10.mvp.presenters

import androidx.lifecycle.Observer
import io.github.aungkothet.padc.assignment10.activities.BaseActivity
import io.github.aungkothet.padc.assignment10.data.models.MovieModelImpl
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment10.mvp.views.MainView
import io.github.aungkothet.padc.assignment10.network.dataAgents.RetrofitAgent
import io.github.aungkothet.padc.assignment10.utils.DataBaseHelper

class MainPresenter : BasePresenter<MainView>(), MovieDelegate {

    fun onUiReady(activity: BaseActivity) {
        val mainMovieList = arrayListOf(
            arrayListOf(),
            arrayListOf(),
            arrayListOf(),
            arrayListOf<MovieVo>()
        )
        MovieModelImpl.getNowPlayingMovies().observe(activity, Observer { list ->
            if (list.isNotEmpty()) {
                val movieList = arrayListOf<MovieVo>()
                list.forEach {
                    movieList.add(it.movieVo)
                }
                mainMovieList[0] =movieList
            }
            mView.showMainMovieList(movieList = mainMovieList)
        })
        MovieModelImpl.getPopularMovies().observe(activity, Observer { list ->
            if (list.isNotEmpty()) {
                val movieList = arrayListOf<MovieVo>()
                list.forEach {
                    movieList.add(it.movieVo)
                }
                mainMovieList[1] = movieList
            }
            mView.showMainMovieList(movieList = mainMovieList)
        })
        MovieModelImpl.getTopRatedMovies().observe(activity, Observer { list ->
            if (list.isNotEmpty()) {
                val movieList = arrayListOf<MovieVo>()
                list.forEach {
                    movieList.add(it.movieVo)
                }
                mainMovieList[2] = movieList
            }
            mView.showMainMovieList(movieList = mainMovieList)
        })
        MovieModelImpl.getUpComingMovies().observe(activity, Observer { list ->
            if (list.isNotEmpty()) {
                val movieList = arrayListOf<MovieVo>()
                list.forEach {
                    movieList.add(it.movieVo)
                }
                mainMovieList[3] = movieList
            }
            mView.showMainMovieList(movieList = mainMovieList)
        })
    }

    fun onSearchButtonClicked(movieName: String,activity: BaseActivity){

        RetrofitAgent.searchMovies(movieName,1,{
            println("${it.size} item got from nw $movieName")
            if(it.isNotEmpty()){
                DataBaseHelper.movieDataBase.movieDao().insertMovies(it)
            }else {
                mView.showResultMovieList(it)
                mView.showErrorMessage("Sorry! No Movies Found! @_@")
            }
        },{
            mView.showErrorMessage(it)
        })
        MovieModelImpl.searchMoviesByName(movieName).observe(activity, Observer {list->
            println("${list.size} item got from db $movieName")
            if (list.isNotEmpty()) {
                mView.showResultMovieList(list)
            }
        })

    }

    override fun onItemClicked(movieId: Int) {
        mView.navigateToMovieDetail(movieId = movieId)
    }

}