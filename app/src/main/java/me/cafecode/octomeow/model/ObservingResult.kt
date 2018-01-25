package me.cafecode.octomeow.model


sealed class ObservingResult<T> {
    data class Success<T>(val data: T?) : ObservingResult<T>()
    data class Loading<T>(val data: T?) : ObservingResult<T>()
    data class Failure<T>(val error: Throwable) : ObservingResult<T>()
}
