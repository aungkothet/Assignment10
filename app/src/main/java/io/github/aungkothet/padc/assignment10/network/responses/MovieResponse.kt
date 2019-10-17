package io.github.aungkothet.padc.assignment10.network.responses

import com.google.gson.annotations.SerializedName
import io.github.aungkothet.padc.assignment10.data.vos.DateVo
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo

data class MovieResponse(
    @SerializedName("page")
    val page:Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val results: List<MovieVo>)