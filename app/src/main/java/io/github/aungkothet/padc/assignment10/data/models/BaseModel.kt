package io.github.aungkothet.padc.assignment10.data.models

import io.github.aungkothet.padc.assignment10.network.dataAgents.MovieDataAgent
import io.github.aungkothet.padc.assignment10.network.dataAgents.RetrofitAgent
import io.github.aungkothet.padc.assignment10.utils.DataBaseHelper

abstract class BaseModel {
    val dataBase = DataBaseHelper.movieDataBase

}