package io.github.aungkothet.padc.assignment10.network

import io.github.aungkothet.padc.assignment10.network.responses.MovieResponse
import io.github.aungkothet.padc.assignment10.network.responses.MovieResponseWithDate
import io.github.aungkothet.padc.assignment10.network.responses.TrailerVideoResponse
import io.github.aungkothet.padc.assignment10.utils.*
import retrofit2.Call
import retrofit2.http.*

interface MovieApi {

    @GET(URL_GET_NOW_PLAYING)
    fun getNowPlayingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponseWithDate>

    @GET(URL_GET_POPULAR)
    fun getPopularMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponse>

    @GET(URL_GET_TOP_RATED)
    fun getTopRatedMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponse>

    @GET(URL_GET_UPCOMING)
    fun getUpComingMovies(@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponseWithDate>

    @GET
    fun getSimilarMovies(@Url fullUrl: String,@Query(PARAM_PAGE) page:Int = 1): Call<MovieResponse>

    @GET
    fun getTrailerVideos(@Url fullUrl: String): Call<TrailerVideoResponse>

    @GET(URL_GET_SEARCH_MOVIES)
    fun getSearchMovies(@Query(PARAM_PAGE) page:Int = 1,@Query(PARAM_QUERY) query: String): Call<MovieResponse>

}