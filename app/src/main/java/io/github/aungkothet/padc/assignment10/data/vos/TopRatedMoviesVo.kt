package io.github.aungkothet.padc.assignment10.data.vos

import androidx.room.*

@Entity(tableName = "movie_top_rated",
    indices = [Index(value = ["tr_id"], unique = true)])
data class TopRatedMoviesVo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "tr_")
    val movieVo: MovieVo
)