package io.github.aungkothet.padc.assignment10.views.holders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.aungkothet.padc.assignment10.R
import io.github.aungkothet.padc.assignment10.adapters.MovieItemAdapter
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MovieDelegate
import kotlinx.android.synthetic.main.layout_movie_list_home.view.*

class MovieListViewHolder(itemView: View, private val title: String,private val delegate: MovieDelegate) : BaseViewHolder<List<MovieVo>>(itemView) {


    override fun bindData(data: List<MovieVo>) {
        itemView.layoutTitle.text = title
        val linearLayoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
        val movieItemAdapter = MovieItemAdapter(delegate,R.layout.item_movie)
        movieItemAdapter.setNewData(data.toMutableList())
        with(itemView.rvItemMovieList){
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = movieItemAdapter
        }


    }


}