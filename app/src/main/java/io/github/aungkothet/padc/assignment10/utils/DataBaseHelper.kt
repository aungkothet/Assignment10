package io.github.aungkothet.padc.assignment10.utils

import android.content.Context
import io.github.aungkothet.padc.assignment10.persistance.MovieDataBase

object DataBaseHelper {
    lateinit var movieDataBase: MovieDataBase

    fun initDatabase(context: Context) {
        movieDataBase = MovieDataBase.getInstance(context)
    }
}