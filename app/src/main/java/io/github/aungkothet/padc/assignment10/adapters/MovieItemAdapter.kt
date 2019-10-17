package io.github.aungkothet.padc.assignment10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment10.views.holders.MovieItemViewHolder

class MovieItemAdapter(private val delegate: MovieDelegate, private val layoutId: Int) :
    BaseRecyclerAdapter<MovieItemViewHolder, MovieVo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MovieItemViewHolder(view, delegate)
    }

}