package io.github.aungkothet.padc.assignment10.network.responses

import com.google.gson.annotations.SerializedName
import io.github.aungkothet.padc.assignment10.data.vos.TrailerVideoVo

data class TrailerVideoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<TrailerVideoVo>?
)