package com.yeditepe.weekthreesectiontwo.week13

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class MathWorker(context: Context,
                 workerParams: WorkerParameters) : Worker(context,workerParams) {

    override fun doWork(): Result {
        val base = inputData.getInt("base",0)
        val pow = inputData.getInt("power",1)
        val sonuc= power(base,pow)
        return Result.success(workDataOf("ustel" to sonuc))
    }
    fun power(base: Int, pow: Int):Int{
        var result=1
        repeat(pow){
            result*=base
        }
        return result
    }
}