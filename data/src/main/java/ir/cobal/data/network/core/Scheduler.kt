package ir.cobal.data.network.core

import io.reactivex.Scheduler

interface Scheduler {
    fun mainThread():Scheduler
    fun io():Scheduler
}