package io.github.aungkothet.padc.assignment10.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import io.github.aungkothet.padc.assignment10.data.vos.*

object MovieModelImpl : BaseModel(), MovieModel {
    override fun searchMoviesByName(movieName: String):List<MovieVo> {
        return dataBase.movieDao().searchMoviesByName("%$movieName%")
    }

    override fun getMovieById(id: Int): MovieVo {
        return dataBase.movieDao().getMovieById(id)
    }

    override fun getUpComingMovies(): LiveData<List<UpComingMoviesVo>> {
        return Transformations.distinctUntilChanged(dataBase.movieDao().getUpComingMovies())
    }

    override fun getPopularMovies(): LiveData<List<PopularMoviesVo>> {
        return Transformations.distinctUntilChanged(dataBase.movieDao().getPopularMovies())
    }

    override fun getTopRatedMovies(): LiveData<List<TopRatedMoviesVo>> {
        return Transformations.distinctUntilChanged(dataBase.movieDao().getTopRatedMovies())
    }

    override fun getSimilarMovies(movieId: Int): LiveData<List<SimilarMoviesVo>> {
        return Transformations.distinctUntilChanged(dataBase.movieDao().getSimilarMovies(movieId))
    }

    override fun getNowPlayingMovies(): LiveData<List<NowPlayingMovieVo>> {
        return Transformations.distinctUntilChanged(dataBase.movieDao().getNowPlayingMovies())
    }

}