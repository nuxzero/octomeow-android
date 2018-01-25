package me.cafecode.octomeow.scheduler

import io.reactivex.Scheduler
import org.jetbrains.annotations.NotNull


interface BaseScheduler {

    @NotNull
    fun computation(): Scheduler

    @NotNull
    fun io(): Scheduler

    @NotNull
    fun ui(): Scheduler

}
