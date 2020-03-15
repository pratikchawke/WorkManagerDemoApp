package com.pratik.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class OneTimeTaskWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

val TAG = OneTimeTaskWorker::class.java.simpleName
    override fun doWork(): Result {

        Log.d(TAG,"This is Worker Thread !!!")

        return Result.success()
    }


}