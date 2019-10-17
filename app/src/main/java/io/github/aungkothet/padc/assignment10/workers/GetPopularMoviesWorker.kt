package io.github.aungkothet.padc.assignment10.workers

import android.content.Context
import androidx.work.WorkerParameters
import io.github.aungkothet.padc.assignment10.network.dataAgents.RetrofitAgent

class GetPopularMoviesWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        RetrofitAgent.getPopularMovies(1,
            {
                result = Result.success()
                dataBase.movieDao().insertToPopularMovies(it)

            },{
                result = Result.failure()
            }
        )
        return result
    }

}