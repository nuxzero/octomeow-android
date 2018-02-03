package me.cafecode.octomeow.extension

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addTo(disposable: CompositeDisposable): Disposable {
    disposable.add(this)
    return disposable
}
