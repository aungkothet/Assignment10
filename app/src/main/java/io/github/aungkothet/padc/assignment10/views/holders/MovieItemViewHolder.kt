package io.github.aungkothet.padc.assignment10.views.holders

import android.view.View
import coil.api.load
import coil.transform.BlurTransformation
import io.github.aungkothet.padc.assignment10.R
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment10.utils.IMAGE_PATH
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieItemViewHolder(itemView: View,private val delegate: MovieDelegate) : BaseViewHolder<MovieVo>(itemView) {
    init {
        itemView.setOnClickListener {
            data?.id?.let { movieId -> delegate.onItemClicked(movieId) }
        }
    }
    override fun bindData(data: MovieVo) {
        itemView.itemMovieImage.load(IMAGE_PATH + data.posterPath){
            placeholder(R.mipmap.ic_launcher_foreground)
        }
    }

}