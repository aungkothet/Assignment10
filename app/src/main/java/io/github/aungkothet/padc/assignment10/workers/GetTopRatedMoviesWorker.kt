package io.github.aungkothet.padc.assignment10.workers

import android.content.Context
import androidx.work.WorkerParameters
import io.github.aungkothet.padc.assignment10.network.dataAgents.RetrofitAgent

class GetTopRatedMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        RetrofitAgent.getTopRatedMovies(page = 1,
            onSuccess = {
                dataBase.movieDao().insertToTopRatedMovies(it)
                result = Result.success()
            }, onFailure = {
                result = Result.failure()
            }
        )
        return result
    }

}