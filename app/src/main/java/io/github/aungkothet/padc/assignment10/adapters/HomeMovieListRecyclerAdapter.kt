package io.github.aungkothet.padc.assignment10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.assignment10.R
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MainPresenterDelegate
import io.github.aungkothet.padc.assignment10.delegates.MovieDelegate
import io.github.aungkothet.padc.assignment10.views.holders.BaseViewHolder
import io.github.aungkothet.padc.assignment10.views.holders.MovieListViewHolder

class HomeMovieListRecyclerAdapter(private val delegate: MovieDelegate)
    : BaseRecyclerAdapter<BaseViewHolder<List<MovieVo>>, List<MovieVo>>() {
    private val vtNowPlaying = 0
    private val vtPopular = 1
    private val vtTopRated = 2
    private val vtUpcoming = 3

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<List<MovieVo>> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_movie_list_home, parent, false)
        return when (viewType) {
            vtNowPlaying -> {
                MovieListViewHolder(view, "Now Playing",delegate)
            }
            vtPopular -> {
                MovieListViewHolder(view, "Popular",delegate)
            }
            vtTopRated -> {
                MovieListViewHolder(view, "Top Rated",delegate)
            }
            else -> {
                MovieListViewHolder(view, "UpComing",delegate)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return when (position) {
            0 -> vtNowPlaying
            1 -> vtPopular
            2 -> vtTopRated
            else -> vtUpcoming
        }
    }
}