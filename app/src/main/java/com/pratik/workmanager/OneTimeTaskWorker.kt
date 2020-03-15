package com.pratik.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class OneTimeTaskWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

val TAG = OneTimeTaskWorker::class.java.simpleName

    override fun doWork(): Result {
        val data = inputData
        val string = data.getString(MainActivity.KEY_INPUT_TEXT)
        Log.d(TAG,string)


        return Result.success()
    }


}