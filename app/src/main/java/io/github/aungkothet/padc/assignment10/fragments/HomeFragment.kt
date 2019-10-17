package io.github.aungkothet.padc.assignment10.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import io.github.aungkothet.padc.assignment10.R
import io.github.aungkothet.padc.assignment10.activities.BaseActivity
import io.github.aungkothet.padc.assignment10.adapters.HomeMovieListRecyclerAdapter
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MainPresenterDelegate
import io.github.aungkothet.padc.assignment10.mvp.presenters.MainPresenter
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var delegate: MainPresenterDelegate
    private lateinit var mPresenter: MainPresenter

    private lateinit var homeMovieListRecyclerAdapter: HomeMovieListRecyclerAdapter
    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MainPresenterDelegate
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        mPresenter = delegate.getPresenter()

        homeMovieListRecyclerAdapter = HomeMovieListRecyclerAdapter(mPresenter)

        val linearLayoutManager = LinearLayoutManager(context)
        with(view.rvMovieListHome){
            adapter = homeMovieListRecyclerAdapter
            layoutManager = linearLayoutManager
        }
        mPresenter.onUiReady(activity as BaseActivity)
        return  view
    }

    fun setNewData(movieList: List<List<MovieVo>>) {
        homeMovieListRecyclerAdapter.setNewData(movieList.toMutableList())
    }

}
