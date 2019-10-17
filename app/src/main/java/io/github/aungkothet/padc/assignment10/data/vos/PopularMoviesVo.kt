package io.github.aungkothet.padc.assignment10.data.vos

import androidx.room.*

@Entity(tableName = "movie_popular",
    indices = [Index(value = ["pop_id"], unique = true)])
data class PopularMoviesVo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "pop_")
    val movieVo: MovieVo
)