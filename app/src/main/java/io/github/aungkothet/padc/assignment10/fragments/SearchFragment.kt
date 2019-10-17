package io.github.aungkothet.padc.assignment10.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import io.github.aungkothet.padc.assignment10.R
import io.github.aungkothet.padc.assignment10.activities.BaseActivity
import io.github.aungkothet.padc.assignment10.adapters.MovieItemAdapter
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MainPresenterDelegate
import io.github.aungkothet.padc.assignment10.mvp.presenters.MainPresenter
import kotlinx.android.synthetic.main.fragment_search.view.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {


    private lateinit var delegate: MainPresenterDelegate
    private lateinit var mPresenter: MainPresenter

    private lateinit var searchResultMoviesRecyclerAdapter: MovieItemAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MainPresenterDelegate
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        mPresenter = delegate.getPresenter()

        searchResultMoviesRecyclerAdapter = MovieItemAdapter(mPresenter,R.layout.item_movie_grid)
        val gridLayoutManager = GridLayoutManager(context, 3)
        with(view.rvSearchResult) {
            adapter = searchResultMoviesRecyclerAdapter
            layoutManager = gridLayoutManager
        }
        view.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                mPresenter.onSearchButtonClicked(query, activity as BaseActivity)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                println("QUERYTEXT {$newText}")
                if(newText.isNullOrEmpty()){
                    searchResultMoviesRecyclerAdapter.data.clear()
                    searchResultMoviesRecyclerAdapter.notifyDataSetChanged()
                }

                return false
            }
        })
        return view
    }

    fun setNewData(movieList: List<MovieVo>) {
        searchResultMoviesRecyclerAdapter.setNewData(movieList.toMutableList())
    }

}
