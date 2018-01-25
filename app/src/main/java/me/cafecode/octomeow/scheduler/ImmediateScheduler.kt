package me.cafecode.octomeow.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


class ImmediateScheduler : BaseScheduler {
    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }
}
