package io.github.aungkothet.padc.assignment10.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_similar")
data class SimilarMoviesVo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @ColumnInfo(name = "movie_id")
    val movieId:Int,
    @Embedded(prefix = "sim_")
    val movieVo: MovieVo
)