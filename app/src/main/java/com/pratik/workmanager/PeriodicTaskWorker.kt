package com.pratik.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class PeriodicTaskWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    val TAG = PeriodicTaskWorker::class.java.simpleName
    override fun doWork(): Result {

        Log.d(TAG, "This is Periodic Worker Thread !!!")
        return Result.success()
    }
}