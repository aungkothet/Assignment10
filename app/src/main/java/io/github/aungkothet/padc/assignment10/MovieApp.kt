package io.github.aungkothet.padc.assignment10

import android.app.Application
import androidx.work.*
import io.github.aungkothet.padc.assignment10.utils.DataBaseHelper
import io.github.aungkothet.padc.assignment10.workers.GetNowPlayingMoviesWorker
import io.github.aungkothet.padc.assignment10.workers.GetPopularMoviesWorker
import io.github.aungkothet.padc.assignment10.workers.GetTopRatedMoviesWorker
import io.github.aungkothet.padc.assignment10.workers.GetUpcomingMoviesWorker
import java.util.concurrent.TimeUnit

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBaseHelper.initDatabase(this)
        getNowPlaying()
        getPopular()
        getTopRated()
        getUpcoming()
        getNowPlayingPeriodically()
        getPopularPeriodically()
        getTopRatedPeriodically()
        getUpcomingPeriodically()
    }

    private fun getNowPlaying() {
        val getNowShowingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowShowingMoviesWorkRequest)
    }
    private fun getTopRated() {
        val getTopRatedMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopular() {
        val getPopularMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetPopularMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcoming() {
        val getUpComingMoviesWorkRequest = OneTimeWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }

    private fun getNowPlayingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getNowShowingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetNowPlayingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getNowShowingMoviesWorkRequest)
    }
    private fun getTopRatedPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getTopRatedMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetTopRatedMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getTopRatedMoviesWorkRequest)
    }
    private fun getPopularPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getPopularMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetPopularMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getPopularMoviesWorkRequest)
    }
    private fun getUpcomingPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val getUpComingMoviesWorkRequest = PeriodicWorkRequest
            .Builder(GetUpcomingMoviesWorker::class.java,30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getUpComingMoviesWorkRequest)
    }

}