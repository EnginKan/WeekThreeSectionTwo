package com.yeditepe.weekthreesectiontwo.week13

import android.content.Context
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf

class MathRepository(val owner: LifecycleOwner,
                     val context: Context) {

    fun calculate(base: Int, power: Int): Int{
        val request= OneTimeWorkRequestBuilder<MathWorker>()
            .setInputData(
                workDataOf("base" to base,"power" to power)
            )
            .build()
        val workId= request.id
        val manager = WorkManager.getInstance(context)
        manager.enqueue(request)
        var sonuc:Int=0
        manager.getWorkInfoByIdLiveData(workId).observe(
            owner, Observer {
                if(it.state== WorkInfo.State.SUCCEEDED)
                    sonuc= it.outputData
                        .getInt("ustel",0)
            }
        )

        return sonuc
    }
}