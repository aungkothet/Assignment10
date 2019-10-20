package io.github.aungkothet.padc.assignment10.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.aungkothet.padc.assignment10.persistance.daos.MovieDao
import io.github.aungkothet.padc.assignment10.data.vos.*
import io.github.aungkothet.padc.assignment10.persistance.typeconverters.GenreListTypeConverter
import io.github.aungkothet.padc.assignment10.utils.DB_NAME

@Database(
    entities = [NowPlayingMovieVo::class, PopularMoviesVo::class, SimilarMoviesVo::class,
        TopRatedMoviesVo::class, UpComingMoviesVo::class,MovieVo::class],
    version = 9,
    exportSchema = false
)
@TypeConverters(GenreListTypeConverter::class)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instances: MovieDataBase? = null
        fun getInstance(context: Context): MovieDataBase {
            if (instances == null) {
                instances = Room.databaseBuilder(context, MovieDataBase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            return instances!!
        }
    }

}