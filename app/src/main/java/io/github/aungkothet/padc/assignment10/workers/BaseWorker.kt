package io.github.aungkothet.padc.assignment10.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import io.github.aungkothet.padc.assignment10.utils.DataBaseHelper

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    protected val dataBase = DataBaseHelper.movieDataBase
}