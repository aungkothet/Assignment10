package io.github.aungkothet.padc.assignment10.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import coil.transform.BlurTransformation
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import io.github.aungkothet.padc.assignment10.R
import io.github.aungkothet.padc.assignment10.adapters.MovieItemAdapter
import io.github.aungkothet.padc.assignment10.data.vos.MovieVo
import io.github.aungkothet.padc.assignment10.mvp.presenters.DetailPresenter
import io.github.aungkothet.padc.assignment10.mvp.views.DetailView
import io.github.aungkothet.padc.assignment10.utils.IMAGE_PATH
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.layout_youtube_video_player.view.*


class MovieDetailActivity : BaseActivity(), DetailView {

    companion object {
        private const val IE_MOVIE = "intentMovie"
        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_MOVIE, id)
            return intent
        }
    }

    private lateinit var mPresenter: DetailPresenter

    private var videoId: String? = ""
    private lateinit var movieItemAdapter: MovieItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        mPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mPresenter.initPresenter(this)

        movieItemAdapter = MovieItemAdapter(mPresenter, R.layout.item_movie)
        mPresenter.onUiReady(intent.getIntExtra(IE_MOVIE, 0), this)

        btnPlayVideo.setOnClickListener {
            mPresenter.onPlayVideoButtonClicked(videoId)
        }

        img_close.setOnClickListener {
            finish()
        }
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        with(rvSimilarMovies) {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = movieItemAdapter
        }

    }

    private fun showTrailerVideoDialog(videoId: String) {
        val mDialogView =
            LayoutInflater.from(this).inflate(R.layout.layout_youtube_video_player, null)
        lifecycle.addObserver(mDialogView.youTubePlayerView)
        mDialogView.youTubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        AlertDialog.Builder(this)
            .setView(mDialogView)
            .show()
    }

    override fun showTrailerVideoDialog() {
        showTrailerVideoDialog(videoId!!)
    }

    override fun bindVideoData(videoId: String?) {
        this.videoId = videoId
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(newIntent(this, movieId))
    }

    override fun bindMovieData(movieVo: MovieVo) {
        imgBgPosterDetail.load(IMAGE_PATH + movieVo.posterPath) {
            transformations(BlurTransformation(this@MovieDetailActivity, 10f))
        }
        imgPosterDetail.load(IMAGE_PATH + movieVo.posterPath)
        tvReleaseDate.text = movieVo.releaseDate
        tvMovieDescDetail.text = movieVo.overview
    }

    override fun showSimilarMovies(movieList: List<MovieVo>) {
        movieItemAdapter.setNewData(movieList.toMutableList())
    }

    override fun showErrorMessage(message: String) {
        showSnackBar(message,rootView)
    }

}
