package com.sebqv97.tabview_api_recyclerview_assessment.utils

sealed class Resource<T>(val data: T? = null, val error: Throwable? = null) {

    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : Resource<T>(data,throwable)
}