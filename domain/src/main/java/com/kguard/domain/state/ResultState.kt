package com.kguard.domain.state

sealed class ResultState<R>{
    data class Success<R>(val data: R): ResultState<R>()
    data class Error<R>(val failure: Failure = Failure.UnHandleError(), val data: R? = null): ResultState<R>()
    class Loading<R>(): ResultState<R>()
}

