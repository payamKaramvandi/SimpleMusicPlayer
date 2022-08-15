package de.skoove.core.domain

sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Failed<T>(throwable: Throwable, data: T? = null) : Resource<T>(data, throwable)
}
