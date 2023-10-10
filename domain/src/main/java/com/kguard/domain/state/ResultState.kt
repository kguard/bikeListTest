package com.kguard.domain.state

sealed class ResultState<R>(val data: R? = null, val message: String = ""){
    class Success<R>(data: R): ResultState<R>(data)
    class Error<R>(message: String, data: R? = null): ResultState<R>(data, message)
    class Loading<R>(data: R? = null): ResultState<R>(data)
}

