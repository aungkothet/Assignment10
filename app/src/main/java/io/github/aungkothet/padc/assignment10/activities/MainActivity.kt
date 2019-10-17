package io.github.aungkothet.padc.assignment10.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.aungkothet.padc.assignment10.R
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.delegates.MainPresenterDelegate
import io.github.aungkothet.padc.assignment10.fragments.HomeFragment
import io.github.aungkothet.padc.assignment10.fragments.SearchFragment
import io.github.aungkothet.padc.assignment10.mvp.presenters.MainPresenter
import io.github.aungkothet.padc.assignment10.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView, MainPresenterDelegate {

    private lateinit var mPresenter: MainPresenter

    private val HOME_TAG = "homeFragment"
    private val SEARCH_TAG = "searchFragment"
    val COMING_SOON_TAG = "commingSoonFragment"

    private val fragmentList = arrayListOf(
        HomeFragment(),
        SearchFragment(), HomeFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = ViewModelProviders.of(this).get(MainPresenter::class.java)
        mPresenter.initPresenter(this)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val transaction = supportFragmentManager.beginTransaction()
        if (supportFragmentManager.findFragmentByTag(HOME_TAG) == null) {
            transaction.add(R.id.main_frame_layout, fragmentList[0], HOME_TAG)
        }
        val currentFragment = supportFragmentManager.findFragmentById(R.id.main_frame_layout)
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        transaction.show(fragmentList[0])
        transaction.commit()

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val transaction = supportFragmentManager.beginTransaction()

            when (item.itemId) {
                R.id.navigation_home -> {
                    if (supportFragmentManager.findFragmentByTag(HOME_TAG) == null) {
                        transaction.add(R.id.main_frame_layout, fragmentList[0], HOME_TAG)
                    }
                    val currentFragment =
                        supportFragmentManager.findFragmentById(R.id.main_frame_layout)
                    if (currentFragment != null) {
                        transaction.hide(currentFragment)
                    }
                    transaction.show(fragmentList[0])
                    transaction.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    if (supportFragmentManager.findFragmentByTag(SEARCH_TAG) == null) {
                        transaction.add(R.id.main_frame_layout,fragmentList[1],SEARCH_TAG)
                    }
                    val currentFragment = supportFragmentManager.findFragmentById(R.id.main_frame_layout)
                    if(currentFragment!=null)
                    {
                        transaction.hide(currentFragment)
                    }
                    transaction.show(fragmentList[1])
                    transaction.commit()
                    return@OnNavigationItemSelectedListener true

                }
                R.id.navigation_coming_soon -> return@OnNavigationItemSelectedListener true
                R.id.navigation_download -> return@OnNavigationItemSelectedListener true
                R.id.navigation_more -> return@OnNavigationItemSelectedListener true
            }
            false
        }

    override fun showResultMovieList(movieList: List<MovieVo>) {
        val fragment =  supportFragmentManager.findFragmentByTag(SEARCH_TAG)
        if(fragment!=null){
            val searchFragment = fragment as SearchFragment
            searchFragment.setNewData(movieList)
        }
    }

    override fun showMainMovieList(movieList: List<List<MovieVo>>) {
        val fragment =  supportFragmentManager.findFragmentByTag(HOME_TAG)
        if(fragment!=null){
            val homeFragment = fragment as HomeFragment
            homeFragment.setNewData(movieList)
        }
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(MovieDetailActivity.newIntent(this,movieId))
    }

    override fun getPresenter(): MainPresenter {
        return mPresenter
    }

    override fun showErrorMessage(message: String) {
        showSnackBar(message,rootView)
    }
}
