package io.github.aungkothet.padc.assignment10.mvp.presenters

import androidx.lifecycle.Observer
import io.github.aungkothet.padc.assignment10.activities.BaseActivity
import io.github.aungkothet.padc.assignment10.data.models.MovieModelImpl
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment10.mvp.views.DetailView
import io.github.aungkothet.padc.assignment10.network.dataAgents.RetrofitAgent
import io.github.aungkothet.padc.assignment10.utils.DataBaseHelper

class DetailPresenter : BasePresenter<DetailView>(), MovieDelegate {

    override fun onItemClicked(movieId: Int) {
        mView.navigateToMovieDetail(movieId = movieId)
    }

    fun onPlayVideoButtonClicked(videoId: String?){
        if(videoId.isNullOrEmpty()){
            mView.showErrorMessage("Sorry!, This movie doesn't have any trailer video(s).")
        }
        else{
            mView.showTrailerVideoDialog()
        }
    }

    fun onUiReady(movieId: Int, activity: BaseActivity) {
        RetrofitAgent.getSimilarMovies(movieId, 1, {
            DataBaseHelper.movieDataBase.movieDao()
                .insertToSimilarMovies(movieList = it, movieId = movieId)
        }, {
            mView.showErrorMessage(it)
        })

        RetrofitAgent.getTrailerVideos(movieId = movieId,onSuccess = {
            val trailerVideoList = it.results
            if(trailerVideoList != null){
                if(trailerVideoList.isNotEmpty()){
                    mView.bindVideoData(trailerVideoList[0].key)
                }
            }else{
                mView.bindVideoData("")
            }
        },onFailure = {
            mView.showErrorMessage(it)
        })

        MovieModelImpl.getSimilarMovies(movieId).observe(activity, Observer { list ->
            if (list.isNotEmpty()) {
                val movieList = arrayListOf<MovieVo>()
                list.forEach {
                    movieList.add(it.movieVo)
                }
                mView.showSimilarMovies(movieList = movieList)
            }
            mView.bindMovieData(MovieModelImpl.getMovieById(movieId))
        })
    }
}